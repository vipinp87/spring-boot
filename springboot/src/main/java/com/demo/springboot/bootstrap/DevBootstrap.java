package com.demo.springboot.bootstrap;


import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.demo.springboot.model.Author;
import com.demo.springboot.model.Book;
import com.demo.springboot.model.Publisher;
import com.demo.springboot.repositories.AuthorRepository;
import com.demo.springboot.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	private AuthorRepository authorRepository;
	
	private PublisherRepository publisherRepository;
	
	public DevBootstrap(AuthorRepository authorRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg) {
		initData();
	}
	
	// To insert some initial data in DB (for testing purpose)
	private void initData() {
		Publisher publisher = new Publisher("O'Reilly", "U.K.");
		publisherRepository.save(publisher);
		
		Author kyle = new Author("Kyle", "simpson");
		Book jsBook = new Book("You don't know JS", "10:abc", publisher);
		kyle.addBook(jsBook);
		authorRepository.save(kyle);
		
		Author kathy = new Author("Kathy", "Sierra");
		Book javaBook = new Book("HeadFirst", "10:xyz", publisher);
		kathy.addBook(javaBook);
		
		authorRepository.save(kathy);
	}

}
