package com.kh.board.model.vo;

public class Category {
	private int categoryNo;
	private String categoryName;
	
	public Category() {
		super();
	}

	public Category(int categoryNo, String categoryName) {
		super();
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
	} // 등록하려는 회원의 입장에서 어떤 카테고리인지 선택하기 위해 생성

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
}
