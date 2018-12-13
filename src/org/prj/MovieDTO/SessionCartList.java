package org.prj.MovieDTO;

import java.util.ArrayList;

public class SessionCartList {
	private ArrayList<Integer> noList = new ArrayList<>();
	private ArrayList<String> titleList = new ArrayList<>();
	private ArrayList<String> imageList = new ArrayList<>();
	private ArrayList<String> directorList = new ArrayList<>();
	private ArrayList<String> rlsDateList = new ArrayList<>();

	public SessionCartList() {
	}

	//set
	public void setNo(int index, int no) {
		this.noList.add(index, no);
	}
	public void setTitle(int index, String title) {
		this.titleList.add(index, title);
	}
	public void setImage(int index, String image) {
		this.imageList.add(index, image);
	}
	public void setDirector(int index, String director) {
		this.directorList.add(index, director);
	}
	public void setRlsDate(int index, String rlsDate) {
		this.rlsDateList.add(index, rlsDate);
	}
	
	//get
	public Integer[] getNo() {
		return noList.toArray(new Integer[noList.size()]);
	}
	public String[] getTitle() {
		return titleList.toArray(new String[titleList.size()]);
	}
	public String[] getImage() {
		return imageList.toArray(new String[imageList.size()]);
	}
	public String[] getDirector() {
		return directorList.toArray(new String[directorList.size()]);
	}
	public String[] getRlsDate() {
		return rlsDateList.toArray(new String[rlsDateList.size()]);
	}
	
	//size
	public int getSize() {
		return noList.size();
	}
	
//	//login
//	
//	public String[] loginCart() {
//		Integer[] loginNo = getNo();
//		String[] loginTitle = getTitle();
//		String[] loginImage = getImage();
//		String[] loginDirector = getDirector();
//		String[] loginRlsDate = getRlsDate();
//		
//		
//	}
}