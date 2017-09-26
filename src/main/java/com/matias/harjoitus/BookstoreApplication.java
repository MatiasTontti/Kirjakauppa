package com.matias.harjoitus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javafx.application.Application;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.matias.harjoitus.Book;
import com.matias.harjoitus.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo (BookRepository repository) {
		return (args) -> {
			log.info("save a couple of books");
			repository.save(new Book("Sinuhe egyptiläinen", "Mika Waltari", 1990, 1232, 30));
			repository.save(new Book("Juoppohullun päiväkirja", "Jukka Jotain", 2000, 1235, 20));

			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
