package com.demo.springboot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springboot.dto.AuthorDto;
import com.demo.springboot.dto.BookDto;
import com.demo.springboot.service.AuthorService;

@RestController
public class AuthorRestController {

	private AuthorService authorService;
	
	public AuthorRestController(AuthorService authorService) {
		this.authorService = authorService;
	}

	@GetMapping("/authors")
	public List<AuthorDto> getAuthors() {
		return authorService.findAll();
	}
	
	@GetMapping("/authors/{id}")
	public AuthorDto getAuthorById(@PathVariable("id") Long id) {
		return authorService.getAuthorById(id);
	}
	
	@GetMapping("/authors/{id}/books")
	public List<BookDto> getAuthorBooks(@PathVariable("id") Long id) {
		return authorService.getAuthorBooks(id);
	}
	
}
