package com.demo.springboot.repositories;

import org.springframework.data.repository.CrudRepository;

import com.demo.springboot.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
