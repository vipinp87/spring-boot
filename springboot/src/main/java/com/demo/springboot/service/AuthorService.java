package com.demo.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.springboot.dto.AuthorDto;
import com.demo.springboot.dto.BookDto;
import com.demo.springboot.model.Author;
import com.demo.springboot.model.Book;
import com.demo.springboot.repositories.AuthorRepository;

@Service
public class AuthorService {

	private AuthorRepository authorRepository;

	@Autowired
	public AuthorService(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
	
	public List<AuthorDto> findAll() {
		Iterable<Author> authors = authorRepository.findAll();
		
		List<AuthorDto> authorDtos = new ArrayList<>();
		authors.forEach(
				author -> authorDtos.add(new AuthorDto(author.getId(), author.getFirstName(), author.getLastName())));
		
		return authorDtos;
	}
	
	public AuthorDto getAuthorById(Long id) {
		Optional<Author> optional = authorRepository.findById(id);
		
		if(optional.isPresent()) {
			Author author = optional.get();
			return new AuthorDto(author.getId(), author.getFirstName(), author.getLastName());
		}

		return null;
	}

	public List<AuthorDto> getAuthorByFirstName(String name) {
		List<Author> authors = authorRepository.findByFirstName(name);
		
		List<AuthorDto> authorDtos = new ArrayList<>();
		authors.forEach(
				author -> authorDtos.add(new AuthorDto(author.getId(), author.getFirstName(), author.getLastName())));
		
		return authorDtos;
	}

	public List<BookDto> getAuthorBooks(Long id) {
		Optional<Author> optional = authorRepository.findById(id);
		
		if(optional.isPresent()) {
			Set<Book> books = optional.get().getBooks();
			
			List<BookDto> bookDtos = new ArrayList<>();
			books.forEach(book -> bookDtos.add(new BookDto(book.getId(), book.getTitle(), book.getIsbn())));
			return bookDtos;
		}

		return null;
	}
}
