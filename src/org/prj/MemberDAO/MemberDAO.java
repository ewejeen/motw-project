package org.prj.MemberDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.prj.DBConnect.DBConnect;
import org.prj.MemberDTO.MemberDTO;

public class MemberDAO {
	private MemberDAO() {
	}

	private static class Singleton {
		private static MemberDAO INSTANCE = new MemberDAO();
	}

	public static MemberDAO getInstance() {
		return Singleton.INSTANCE;
	}

	///// 회원가입
	public int signUp(MemberDTO dto) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "insert into member(username, userPw, userEmail) values(?,?,?)";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, dto.getUsername());
			pstm.setString(2, dto.getUserPw());
			pstm.setString(3, dto.getUserEmail());

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

	///// 로그인
	public int signIn(String username, String userPw) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";
		ResultSet rs = null;

		try {
			conn = DBConnect.getConnection();
			query = "select count(*) from member where username=? and userPw=?";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, username);
			pstm.setString(2, userPw);

			rs = pstm.executeQuery();
			while (rs.next()) {
				result = rs.getInt(1); // 결과값이 1이면 로그인 성공
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

	///// 아이디 중복 체크
	public int nameCheck(String username) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";
		ResultSet rs = null;

		try {
			conn = DBConnect.getConnection();
			query = "select count(*) from member where username=?";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, username);

			rs = pstm.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					result = rs.getInt(1);
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

	///// 이메일 중복 체크
	public int emailCheck(String userEmail) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";
		ResultSet rs = null;

		try {
			conn = DBConnect.getConnection();
			query = "select count(*) from member where userEmail=?";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, userEmail);

			rs = pstm.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					result = rs.getInt(1);
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

	///// 아이디 찾기
	public String nameFind(String userEmail) {
		String result = "";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "select username from member where userEmail=?";
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userEmail);

			rs = pstm.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					result = rs.getString(1);
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

	///// 비밀번호 찾기
	public String pwFind(String username, String userEmail) {
		String result = "";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "select userPw from member where username=? and userEmail=?";
			pstm = conn.prepareStatement(query);
			pstm.setString(1, username);
			pstm.setString(2, userEmail);

			rs = pstm.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					result = rs.getString(1);
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

	///// 회원 정보 보기
	public MemberDTO view(String username) {
		MemberDTO result = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "select * from member where username=?";
			pstm = conn.prepareStatement(query);
			pstm.setString(1, username);

			rs = pstm.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					String username2 = rs.getString(1);
					String userPw = rs.getString(2);
					String userEmail = rs.getString(3);

					result = new MemberDTO(username2, userPw, userEmail);
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

	///// 회원 탈퇴
	public int delete(String username, String userPw) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "delete from member where username=? and userPw=?";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, username);
			pstm.setString(2, userPw);

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

	///// 회원수정
	public int modify(MemberDTO dto) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "update member set userPw=?, userEmail=? where username=?";
			pstm = conn.prepareStatement(query);

			pstm.setString(1, dto.getUserPw());
			pstm.setString(2, dto.getUserEmail());
			pstm.setString(3, dto.getUsername());

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

	///// 회원 목록(관리자용)
	public ArrayList<MemberDTO> list() {
		ArrayList<MemberDTO> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";

		try {
			conn = DBConnect.getConnection();
			query = "SELECT * FROM member ORDER BY username ASC";
			pstm = conn.prepareStatement(query);

			rs = pstm.executeQuery();
			while (rs.next()) {
				String username = rs.getString("username");
				String userPw = rs.getString("userPw");
				String userEmail = rs.getString("userEmail");

				result.add(new MemberDTO(username, userPw, userEmail));
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
