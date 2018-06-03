package com.demo.springboot.dto;

public class BookDto {

	private Long id;
	
	private String title;
	
	private String isbn;

	public BookDto() {
		super();
	}

	public BookDto(Long id, String title, String isbn) {
		super();
		this.id = id;
		this.title = title;
		this.isbn = isbn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	
}
