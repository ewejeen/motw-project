package org.prj.MovieDTO;

import java.util.ArrayList;

public class Cart {
	private ArrayList<Integer> noList = new ArrayList<>();

	public void addItem(int no) {
		noList.add(no);
	}

	public boolean deleteItem(int no) {
		return noList.remove((Integer) no);
	}

	public int dupItem(int no) {
		int result;
		if (noList.contains(no)) {
			result = 1;
		} else {
			result = 0;
		}
		return result;
	}

	public int getNo(int index) {
		return noList.get(index);
	}

	public int getSize() {
		return noList.size();
	}
}
