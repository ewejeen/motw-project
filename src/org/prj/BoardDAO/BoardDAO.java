package org.prj.BoardDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.prj.BoardDTO.BoardDTO;
import org.prj.BoardDTO.LikeDTO;
import org.prj.BoardDTO.PagingClass;
import org.prj.DBConnect.DBConnect;

public class BoardDAO {
	private BoardDAO() {
	}

	private static class Singleton {
		private static final BoardDAO INSTANCE = new BoardDAO();
	}

	public static BoardDAO getInstance() {
		return Singleton.INSTANCE;
	}

	///// Community 게시글 페이징 구현
	public PagingClass paging(int pNum) {
		PagingClass pagingList = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";

		int rowSize = 5;
		int block = 5;
		int startNum = (pNum - 1) * rowSize;
		int endNum = rowSize;

		int startPage = ((pNum - 1) / block) * block + 1;
		int endPage = startPage + block - 1;
		int totalPage = 0;
		int total = 0;

		try {
			conn = DBConnect.getConnection();
			query = "SELECT COUNT(*) FROM community WHERE step = 0";
			pstm = conn.prepareStatement(query);

			rs = pstm.executeQuery();
			if (rs.next()) {
				total = rs.getInt(1);
			}
			totalPage = (int) Math.ceil(total / (double) rowSize);
			if (endPage > totalPage) {
				endPage = totalPage;
			}

			pagingList = new PagingClass(pNum, rowSize, block, startNum, endNum, total, totalPage, startPage, endPage);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					conn.close();
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			}
		}

		return pagingList;
	}

	///// Community 게시글 검색 시 페이징 구현
	public PagingClass pagingSearch(int pNum, String crit, String search) {
		PagingClass pagingList = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";

		int rowSize = 5;
		int block = 5;
		int startNum = (pNum - 1) * rowSize;
		int endNum = rowSize;

		int startPage = ((pNum - 1) / block) * block + 1;
		int endPage = startPage + block - 1;
		int totalPage = 0;
		int total = 0;

		try {
			conn = DBConnect.getConnection();
			query = "SELECT COUNT(*) FROM community WHERE " + crit + " LIKE ? AND step = 0";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, "%" + search + "%");

			rs = pstm.executeQuery();
			if (rs.next()) {
				total = rs.getInt(1);
			}
			totalPage = (int) Math.ceil(total / (double) rowSize);
			if (endPage > totalPage) {
				endPage = totalPage;
			}

			pagingList = new PagingClass(pNum, rowSize, block, startNum, endNum, total, totalPage, startPage, endPage);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					conn.close();
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			}
		}

		return pagingList;
	}

	///// Community 게시글 목록
	public ArrayList<BoardDTO> list(int startNum, int endNum) {
		ArrayList<BoardDTO> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "SELECT * FROM community WHERE step = 0 ORDER BY cGroup DESC LIMIT ?, ?";
			pstm = conn.prepareStatement(query);

			pstm.setInt(1, startNum);
			pstm.setInt(2, endNum);

			rs = pstm.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					int no = rs.getInt(1);
					int cGroup = rs.getInt(2);
					int indent = rs.getInt(3);
					int step = rs.getInt(4);
					String title = rs.getString(5);
					String content = rs.getString(6);
					String username = rs.getString(7);
					Timestamp regDate = rs.getTimestamp(8);
					int likeCnt = rs.getInt(9);
					int hit = rs.getInt(10);

					result.add(new BoardDTO(no, cGroup, indent, step, title, content, username, regDate, likeCnt, hit));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					pstm.close();
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			}
		}

		return result;
	}

	///// Community 게시글 작성
	public int write(String title, String content, String username) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "INSERT INTO community(cGroup, indent, step, title, content, username, regDate, likeCnt, hit)"
					+ "VALUES((SELECT CASE COUNT(*) WHEN 0 THEN 1 ELSE max(cGroup)+1 END FROM community c1),"
					+ "0,0,?,?,?,sysdate(),0,0)";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, title);
			pstm.setString(2, content);
			pstm.setString(3, username);

			result = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					pstm.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			}
		}

		return result;
	}

	///// Community 게시글 검색
	public ArrayList<BoardDTO> search(String crit, String search, int startNum, int endNum) {
		ArrayList<BoardDTO> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "SELECT * FROM community WHERE " + crit + " LIKE ? AND step = 0 ORDER BY cGroup DESC LIMIT ?, ?";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, "%" + search + "%");
			pstm.setInt(2, startNum);
			pstm.setInt(3, endNum);

			rs = pstm.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					int no = rs.getInt(1);
					int cGroup = rs.getInt(2);
					int indent = rs.getInt(3);
					int step = rs.getInt(4);
					String title = rs.getString(5);
					String content = rs.getString(6);
					String username = rs.getString(7);
					Timestamp regDate = rs.getTimestamp(8);
					int likeCnt = rs.getInt(9);
					int hit = rs.getInt(10);

					result.add(new BoardDTO(no, cGroup, indent, step, title, content, username, regDate, likeCnt, hit));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					pstm.close();
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			}
		}

		return result;
	}

	///// Community 게시글 조회수+1
	public int upHit(int no) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "UPDATE community SET hit=hit+1 WHERE no=?";
			pstm = conn.prepareStatement(query);

			pstm.setInt(1, no);

			result = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					pstm.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			}
		}

		return result;
	}

	///// Community 게시글 보기
	public BoardDTO view(int no) {

		upHit(no);

		BoardDTO result = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "SELECT * FROM community WHERE no=?";
			pstm = conn.prepareStatement(query);

			pstm.setInt(1, no);

			rs = pstm.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					int no2 = rs.getInt(1);
					int cGroup = rs.getInt(2);
					int indent = rs.getInt(3);
					int step = rs.getInt(4);
					String title = rs.getString(5);
					String content = rs.getString(6);
					String username = rs.getString(7);
					Timestamp regDate = rs.getTimestamp(8);
					int likeCnt = rs.getInt(9);
					int hit = rs.getInt(10);

					result = new BoardDTO(no2, cGroup, indent, step, title, content, username, regDate, likeCnt, hit);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					pstm.close();
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			}
		}

		return result;
	}

	///// Community 게시글 삭제
	public int delete(int no) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "DELETE FROM community WHERE no=?";
			pstm = conn.prepareStatement(query);

			pstm.setInt(1, no);

			result = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					pstm.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			}
		}

		return result;
	}

	///// Community 게시글 수정 View (조회수+1 기능 빼야 하므로 다시 정의)
	public BoardDTO editView(int no) {

		BoardDTO result = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "SELECT * FROM community WHERE no=?";
			pstm = conn.prepareStatement(query);

			pstm.setInt(1, no);

			rs = pstm.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					int no2 = rs.getInt(1);
					int cGroup = rs.getInt(2);
					int indent = rs.getInt(3);
					int step = rs.getInt(4);
					String title = rs.getString(5);
					String content = rs.getString(6);
					String username = rs.getString(7);
					Timestamp regDate = rs.getTimestamp(8);
					int likeCnt = rs.getInt(9);
					int hit = rs.getInt(10);

					result = new BoardDTO(no2, cGroup, indent, step, title, content, username, regDate, likeCnt, hit);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					pstm.close();
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			}
		}

		return result;
	}

	///// Community 게시글 수정
	public int edit(String title, String content, int no) {

		int result = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "UPDATE community SET title=?, content=? WHERE no=?";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, title);
			pstm.setString(2, content);
			pstm.setInt(3, no);

			result = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					pstm.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			}
		}

		return result;
	}

	///// Community 댓글 작성
	public int reply(int cGroup, int indent, int step, String content, String username) {
		int result = 0;
		replyShape(cGroup, step);
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "INSERT INTO community(cGroup, indent, step, title, content, username, regDate) "
					+ "VALUES(?,?,?,'reply',?,?,sysdate())";
			pstm = conn.prepareStatement(query);

			pstm.setInt(1, cGroup);
			pstm.setInt(2, step + 1);
			pstm.setInt(3, indent + 1);
			pstm.setString(4, content);
			pstm.setString(5, username);

			result = pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					pstm.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			}
		}

		return result;
	}

	///// Community 댓글 작성 update
	public int replyShape(int cGroup, int step) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "UPDATE community SET step=step+1 WHERE cGroup=? AND step > ?";
			pstm = conn.prepareStatement(query);

			pstm.setInt(1, cGroup);
			pstm.setInt(2, step);

			result = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					pstm.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			}
		}

		return result;
	}

	///// Community 댓글 목록
	public ArrayList<BoardDTO> replyList(int cGroup) {
		ArrayList<BoardDTO> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "SELECT * FROM community WHERE cGroup=? AND step>0 ORDER BY step ASC, indent ASC";
			pstm = conn.prepareStatement(query);

			pstm.setInt(1, cGroup);

			rs = pstm.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					int no = rs.getInt(1);
					int cGroup2 = rs.getInt(2);
					int indent = rs.getInt(3);
					int step = rs.getInt(4);
					String title = rs.getString(5);
					String content = rs.getString(6);
					String username = rs.getString(7);
					Timestamp regDate = rs.getTimestamp(8);
					int likeCnt = rs.getInt(9);
					int hit = rs.getInt(10);

					BoardDTO dto = new BoardDTO(no, cGroup2, indent, step, title, content, username, regDate, likeCnt,
							hit);
					result.add(dto);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					pstm.close();
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			}
		}

		return result;
	}

	///// Community 게시글 좋아요-1(이미 좋아요를 누른 경우)
	public int unlike(String username, int boardno) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			// query = "UPDATE clike SET likeCheck=? WHERE username=? and boardno=?";
			query = "DELETE FROM clike WHERE userName=? AND boardno=? AND likeCheck=1";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, username);
			pstm.setInt(2, boardno);

			result = pstm.executeUpdate();

			downLike(boardno);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					pstm.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			}
		}

		return result;
	}

	public int like(String username, int boardno) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			// query = "UPDATE clike SET likeCheck=? WHERE username=? and boardno=?";
			query = "INSERT INTO clike(likeCheck, username, boardno) VALUES(1,?,?) ";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, username);
			pstm.setInt(2, boardno);

			result = pstm.executeUpdate();

			upLike(boardno);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					pstm.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			}
		}

		return result;
	}

	///// Community 게시글 좋아요+1
	public void upLike(int no) {
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "UPDATE community SET likeCnt=likeCnt+1 WHERE no=?";
			pstm = conn.prepareStatement(query);

			pstm.setInt(1, no);

			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					pstm.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			}
		}

	}

	///// Community 게시글 좋아요-1
	public void downLike(int no) {
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "UPDATE community SET likeCnt=likeCnt-1 WHERE no=?";
			pstm = conn.prepareStatement(query);

			pstm.setInt(1, no);

			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					pstm.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			}
		}
	}

	///// Community 게시글 좋아요 리스트
	public ArrayList<LikeDTO> likeList(int boardno) {
		ArrayList<LikeDTO> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";
		ResultSet rs = null;

		try {
			conn = DBConnect.getConnection();
			query = "SELECT * FROM clike WHERE boardno=?";
			pstm = conn.prepareStatement(query);

			pstm.setInt(1, boardno);

			rs = pstm.executeQuery();

			while (rs.next()) {
				int boardno2 = rs.getInt(1);
				String username = rs.getString(2);
				int likeCheck = rs.getInt(3);

				result.add(new LikeDTO(boardno2, username, likeCheck));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					pstm.close();
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			}
		}
		return result;
	}

	///// 좋아요 했는지 확인
	public int getLikeCheck(String username, int boardno) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";
		ResultSet rs = null;

		try {
			conn = DBConnect.getConnection();
			query = "SELECT likeCheck FROM clike WHERE username=? AND boardno=?";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, username);
			pstm.setInt(2, boardno);

			rs = pstm.executeQuery();

			while (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					pstm.close();
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			}
		}

		return result;
	}

	///// Community 대댓글
	public int rereply(int cGroup, int indent, int step, String title, String content, String username) {
		int result = 0;
		rereplyShape(cGroup, step);
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "INSERT INTO community(cGroup, indent, step, title, content, username, regDate) "
					+ "VALUES(?,?,?,?,?,?,sysdate())";
			pstm = conn.prepareStatement(query);
			String re = new String(new char[indent]).replace("\0", "Re: ");

			pstm.setInt(1, cGroup);
			pstm.setInt(2, step + 1);
			pstm.setInt(3, ++indent);
			pstm.setString(4, title);
			pstm.setString(5, re + content);
			pstm.setString(6, username);

			result = pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					pstm.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			}
		}

		return result;
	}

	///// Community 댓글 작성 update
	public int rereplyShape(int cGroup, int step) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "UPDATE community SET step=step+1 WHERE cGroup=? AND step > ? ";
			pstm = conn.prepareStatement(query);

			pstm.setInt(1, cGroup);
			pstm.setInt(2, step);

			result = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					pstm.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			}
		}

		return result;
	}
}
