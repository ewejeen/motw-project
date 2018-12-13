package org.prj.MovieDTO;

import java.sql.Timestamp;

public class CartList {
	private String username;
	private String title;
	private String image;
	private String director;
	private String rlsDate;
	private Timestamp cartDate;

	public CartList() {
	}

	public CartList(String username, String title, String image, String director, String rlsDate, Timestamp cartDate) {
		super();
		this.username = username;
		this.title = title;
		this.image = image;
		this.director = director;
		this.rlsDate = rlsDate;
		this.cartDate = cartDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getRlsDate() {
		return rlsDate;
	}

	public void setRlsDate(String rlsDate) {
		this.rlsDate = rlsDate;
	}

	public Timestamp getCartDate() {
		return cartDate;
	}

	public void setCartDate(Timestamp cartDate) {
		this.cartDate = cartDate;
	}

}