package org.prj.MovieDTO;

import java.sql.Timestamp;

public class MovieDTO {
	private int no;
	private String title;
	private String content;
	private String catchph;
	private String username;
	private String image;
	private String director;
	private String stars;
	private String rlsDate;
	private Timestamp regDate;
	private int likeCnt;
	private int hit;
	private String rotten;
	private String imdb;
	private String wiki;
	private String youtube;

	public MovieDTO(int no, String title, String content, String catchph, String username, String image,
			String director, String stars, String rlsDate, Timestamp regDate, int likeCnt, int hit, String rotten,
			String imdb, String wiki, String youtube) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.catchph = catchph;
		this.username = username;
		this.image = image;
		this.director = director;
		this.stars = stars;
		this.rlsDate = rlsDate;
		this.regDate = regDate;
		this.likeCnt = likeCnt;
		this.hit = hit;
		this.rotten = rotten;
		this.imdb = imdb;
		this.wiki = wiki;
		this.youtube = youtube;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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

	public String getCatchph() {
		return catchph;
	}

	public void setCatchph(String catchph) {
		this.catchph = catchph;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getStars() {
		return stars;
	}

	public void setStars(String stars) {
		this.stars = stars;
	}

	public String getRlsDate() {
		return rlsDate;
	}

	public void setRlsDate(String rlsDate) {
		this.rlsDate = rlsDate;
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

	public String getRotten() {
		return rotten;
	}

	public void setRotten(String rotten) {
		this.rotten = rotten;
	}

	public String getImdb() {
		return imdb;
	}

	public void setImdb(String imdb) {
		this.imdb = imdb;
	}

	public String getWiki() {
		return wiki;
	}

	public void setWiki(String wiki) {
		this.wiki = wiki;
	}

	public String getYoutube() {
		return youtube;
	}

	public void setYoutube(String youtube) {
		this.youtube = youtube;
	}

}
