package com.demo.springboot.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.demo.springboot.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
	
	public List<Author> findByFirstName(String firstName);

}
