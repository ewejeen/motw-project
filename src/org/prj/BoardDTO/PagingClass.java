package org.prj.BoardDTO;

public class PagingClass {
	private int pNum; // 현재 페이지
	private int rowSize; // 한 페이지 당 글(레코드) 수
	private int block; // 한 페이지 (하단)에 보일 페이지 수
	private int startNum; // 해당 페이지에서 가져올 첫 번째 글(레코드) - LIMIT
	private int endNum; // 해당 페이지에서 가져올 글(레코드)의 개수 - LIMIT
	private int total; // 전체 글(레코드) 수
	private int totalPage; // 전체 페이지 수
	private int startPage; // 해당 블록의 첫 번째 페이지 ex) 12345 678910 등으로 끊는다면 1, 6
	private int endPage; // 해당 블록의 마지막 페이지 ex) 12345 678910 등으로 끊는다면 5, 10

	public PagingClass() {
	}

	public PagingClass(int pNum, int rowSize, int block, int startNum, int endNum, int total, int totalPage,
			int startPage, int endPage) {
		super();
		this.pNum = pNum;
		this.rowSize = rowSize;
		this.block = block;
		this.startNum = startNum;
		this.endNum = endNum;
		this.total = total;
		this.totalPage = totalPage;
		this.startPage = startPage;
		this.endPage = endPage;
	}

	public int getpNum() {
		return pNum;
	}

	public void setpNum(int pNum) {
		this.pNum = pNum;
	}

	public int getRowSize() {
		return rowSize;
	}

	public void setRowSize(int rowSize) {
		this.rowSize = rowSize;
	}

	public int getBlock() {
		return block;
	}

	public void setBlock(int block) {
		this.block = block;
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getEndNum() {
		return endNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

}
