package org.prj.BoardDTO;

import java.sql.Timestamp;

public class BoardDTO {
	private int no;
	private int cGroup;
	private int indent;
	private int step;
	private String title;
	private String content;
	private String username;
	private Timestamp regDate;
	private int likeCnt;
	private int hit;

	public BoardDTO() {
	}

	public BoardDTO(int no, int cGroup, int indent, int step, String title, String content, String username,
			Timestamp regDate, int likeCnt, int hit) {
		super();
		this.no = no;
		this.cGroup = cGroup;
		this.indent = indent;
		this.step = step;
		this.title = title;
		this.content = content;
		this.username = username;
		this.regDate = regDate;
		this.likeCnt = likeCnt;
		this.hit = hit;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getcGroup() {
		return cGroup;
	}

	public void setcGroup(int cGroup) {
		this.cGroup = cGroup;
	}

	public int getIndent() {
		return indent;
	}

	public void setIndent(int indent) {
		this.indent = indent;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	public int getLikeCnt() {
		return likeCnt;
	}

	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

}
