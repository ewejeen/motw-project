package org.prj.MemberDTO;

public class MemberDTO {
	private String username;
	private String userPw;
	private String userEmail;

	public MemberDTO() {
	}

	public MemberDTO(String username, String userPw, String userEmail) {
		super();
		this.username = username;
		this.userPw = userPw;
		this.userEmail = userEmail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

}
