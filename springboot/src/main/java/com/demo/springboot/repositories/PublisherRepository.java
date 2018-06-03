package com.demo.springboot.repositories;

import org.springframework.data.repository.CrudRepository;

import com.demo.springboot.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
