package com.sparta.ua.libraryproject;

import com.sparta.ua.libraryproject.model.entities.AuthorDTO;
import com.sparta.ua.libraryproject.model.entities.BookDTO;
import com.sparta.ua.libraryproject.model.repositories.AuthorRepository;
import com.sparta.ua.libraryproject.model.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class LibraryProjectApplication {

	private Logger logger = Logger.getLogger(LibraryProjectApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(LibraryProjectApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(AuthorRepository authorRepository){
		return args -> {
//			AuthorDTO Affiq = new AuthorDTO();
//			Affiq.setFullName("Affiq");
//			authorRepository.save(Affiq);
//			authorRepository.deleteById(1);

			logger.log(Level.INFO,authorRepository.findAll().toString());
		};
	}
	@Bean
	public CommandLineRunner runner2(BookRepository bookRepository){
		return args -> {
			ArrayList<BookDTO> allBooks = (ArrayList<BookDTO>) bookRepository.findAll();
			logger.log(Level.INFO,allBooks.toString());
		};
	}//tells spring I need you to creates a class. bean is a class spring has control over. because it's an interface.



}
