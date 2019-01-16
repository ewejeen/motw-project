package org.prj.MovieDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.prj.BoardDTO.PagingClass;
import org.prj.DBConnect.DBConnect;
import org.prj.MovieDTO.Cart;
import org.prj.MovieDTO.CartList;
import org.prj.MovieDTO.MovieDTO;
import org.prj.MovieDTO.SessionCartList;

public class MovieDAO {
	private MovieDAO() {
	}

	private static class Singleton {
		private static final MovieDAO INSTANCE = new MovieDAO();
	}

	public static MovieDAO getInstance() {
		return Singleton.INSTANCE;
	}

	///// ThisWeek 게시글 페이징 구현
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
			query = "SELECT COUNT(*) FROM thisweek";
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

	///// ThisWeek 게시글 검색 시 페이징 구현
	public PagingClass paging(int pNum, String crit, String search) {
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
			query = "SELECT COUNT(*) FROM thisweek WHERE " + crit + " LIKE ?";
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

	///// ThisWeek 게시글 목록
	public ArrayList<MovieDTO> list(int startNum, int endNum) {
		ArrayList<MovieDTO> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "SELECT * FROM thisweek ORDER BY no DESC LIMIT ?, ?";
			pstm = conn.prepareStatement(query);

			pstm.setInt(1, startNum);
			pstm.setInt(2, endNum);

			rs = pstm.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					int no = rs.getInt("no");
					String title = rs.getString("title");
					String content = rs.getString("content");
					String catchph = rs.getString("catchph");
					String username = rs.getString("username");
					String image = rs.getString("image");
					String director = rs.getString("director");
					String stars = rs.getString("stars");
					String rlsDate = rs.getString("rlsDate");
					Timestamp regDate = rs.getTimestamp("regDate");
					String rotten = rs.getString("rotten");
					String imdb = rs.getString("imdb");
					String wiki = rs.getString("wiki");
					String youtube = rs.getString("youtube");

					result.add(new MovieDTO(no, title, content, catchph, username, image, director, stars, rlsDate,
							regDate, rotten, imdb, wiki, youtube));
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

	///// ThisWeek 게시글 작성
	public int write(String title, String content, String catchph, String username, String image, String director,
			String stars, String rlsDate, String rotten, String imdb, String wiki, String youtube) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "INSERT INTO thisweek(title, content, catchph, username, image, director, stars, rlsDate, regDate, rotten, imdb, wiki, youtube)"
					+ "VALUES(?,?,?,?,?,?,?,?,sysdate(),?,?,?,?)";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, title);
			pstm.setString(2, content);
			pstm.setString(3, catchph);
			pstm.setString(4, username);
			pstm.setString(5, image);
			pstm.setString(6, director);
			pstm.setString(7, stars);
			pstm.setString(8, rlsDate);
			pstm.setString(9, rotten);
			pstm.setString(10, imdb);
			pstm.setString(11, wiki);
			pstm.setString(12, youtube);

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

	///// ThisWeek 게시글 검색
	public ArrayList<MovieDTO> search(String crit, String search, int startNum, int endNum) {
		ArrayList<MovieDTO> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "SELECT * FROM thisweek WHERE " + crit + " LIKE ? ORDER BY no DESC LIMIT ?, ?";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, "%" + search + "%");
			pstm.setInt(2, startNum);
			pstm.setInt(3, endNum);

			rs = pstm.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					int no = rs.getInt("no");
					String title = rs.getString("title");
					String content = rs.getString("content");
					String catchph = rs.getString("catchph");
					String username = rs.getString("username");
					String image = rs.getString("image");
					String director = rs.getString("director");
					String stars = rs.getString("stars");
					String rlsDate = rs.getString("rlsDate");
					Timestamp regDate = rs.getTimestamp("regDate");
					String rotten = rs.getString("rotten");
					String imdb = rs.getString("imdb");
					String wiki = rs.getString("wiki");
					String youtube = rs.getString("youtube");

					result.add(new MovieDTO(no, title, content, catchph, username, image, director, stars, rlsDate,
							regDate, rotten, imdb, wiki, youtube));
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

	///// ThisWeek 게시글 보기
	public MovieDTO view(String title, String rlsDate) {
		MovieDTO result = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "SELECT * FROM thisweek WHERE title=? AND rlsDate=?";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, title);
			pstm.setString(2, rlsDate);

			rs = pstm.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					int no = rs.getInt("no");
					String title2 = rs.getString("title");
					String content = rs.getString("content");
					String catchph = rs.getString("catchph");
					String username = rs.getString("username");
					String image = rs.getString("image");
					String director = rs.getString("director");
					String stars = rs.getString("stars");
					String rlsDate2 = rs.getString("rlsDate");
					Timestamp regDate = rs.getTimestamp("regDate");
					String rotten = rs.getString("rotten");
					String imdb = rs.getString("imdb");
					String wiki = rs.getString("wiki");
					String youtube = rs.getString("youtube");

					result = new MovieDTO(no, title2, content, catchph, username, image, director, stars, rlsDate2,
							regDate, rotten, imdb, wiki, youtube);
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

	///// ThisWeek 게시글 삭제
	public int delete(int no) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "DELETE FROM thisweek WHERE no=?";
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

	///// ThisWeek 게시글 수정
	public int edit(String title, String content, String catchph, String director, String stars, String rlsDate,
			String rotten, String imdb, String wiki, String youtube, int no) {

		int result = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "UPDATE thisweek SET title=?, content=?, catchph=?, director=?, stars=?, rlsDate=?, rotten=?, imdb=?, wiki=?, youtube=? WHERE no=?";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, title);
			pstm.setString(2, content);
			pstm.setString(3, catchph);
			pstm.setString(4, director);
			pstm.setString(5, stars);
			pstm.setString(6, rlsDate);
			pstm.setString(7, rotten);
			pstm.setString(8, imdb);
			pstm.setString(9, wiki);
			pstm.setString(10, youtube);
			pstm.setInt(11, no);

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

	// 비로그인 시 카트 목록
	public SessionCartList cartListS(Cart cart) {
		SessionCartList result = new SessionCartList();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			for (int i = 0; i < cart.getSize(); i++) {

				int no = cart.getNo(i);
				query = "SELECT title, image, director, rlsDate FROM thisweek WHERE no=?";
				pstm = conn.prepareStatement(query);

				pstm.setInt(1, no);
				rs = pstm.executeQuery();

				while (rs.next()) {
					String title = rs.getString("title");
					String image = rs.getString("image");
					String director = rs.getString("director");
					String rlsDate = rs.getString("rlsDate");

					result.setNo(i, no);
					result.setTitle(i, title);
					result.setImage(i, image);
					result.setDirector(i, director);
					result.setRlsDate(i, rlsDate);
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

	// 로그인 시 카트 목록
	public ArrayList<CartList> cartListT(String username) {
		ArrayList<CartList> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "SELECT * FROM cart WHERE username=? ORDER BY cartDate ASC";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, username);
			rs = pstm.executeQuery();

			while (rs.next()) {
				String username2 = rs.getString("username");
				String title = rs.getString("title");
				String image = rs.getString("image");
				String director = rs.getString("director");
				String rlsDate = rs.getString("rlsDate");
				Timestamp cartDate = rs.getTimestamp("cartDate");

				result.add(new CartList(username2, title, image, director, rlsDate, cartDate));
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

	// 로그인 시 카트에 담기
	public int cartAdd(String username, String title, String image, String director, String rlsDate) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "INSERT INTO cart(username, title, image, director, rlsDate, cartDate) VALUES(?,?,?,?,?,now())";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, username);
			pstm.setString(2, title);
			pstm.setString(3, image);
			pstm.setString(4, director);
			pstm.setString(5, rlsDate);

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

	// 로그인 시 카트 항목 삭제
	public int cartDelete(String title, String rlsDate, String username) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "DELETE FROM cart WHERE title=? AND rlsDate=? AND username=?";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, title);
			pstm.setString(2, rlsDate);
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

	///// 로그인 시 카트에 넣을 때 카트에 이미 등록된 영화인지 중복 확인
	public int tCartCheck(String username, String title) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "SELECT COUNT(*) FROM cart WHERE username=? and title=?";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, username);
			pstm.setString(2, title);

			rs = pstm.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					result = rs.getInt(1); // 결과값이 1이면 중복
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
}
