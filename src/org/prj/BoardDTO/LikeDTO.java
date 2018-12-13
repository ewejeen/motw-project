package org.prj.BoardDTO;

public class LikeDTO {
	private int boardno;
	private String username;
	private int likeCheck;

	public LikeDTO() {
	}

	public LikeDTO(int boardno, String username, int likeCheck) {
		super();
		this.boardno = boardno;
		this.username = username;
		this.likeCheck = likeCheck;
	}

	public int getBoardno() {
		return boardno;
	}

	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getLikeCheck() {
		return likeCheck;
	}

	public void setLikeCheck(int likeCheck) {
		this.likeCheck = likeCheck;
	}

}
