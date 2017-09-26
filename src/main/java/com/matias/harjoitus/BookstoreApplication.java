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
	public CommandLineRunner bookDemo (BookRepository repository, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of books");
			repository.save(new Book("Sinuhe egyptiläinen", "Mika Waltari", 1990, 1232, 30));
			repository.save(new Book("Juoppohullun päiväkirja", "Jukka Jotain", 2000, 1235, 20));

			User user1 = new User("user",
					"$2a$04$CgUhBId.PFwq//Vfh.9Mweu8ZlR8Nkb.UrJUd86OOGE1XddSjWITS", "USER");
			//user1
			User user2 = new User("admin",
					"$2a$04$bpfPOcSgatKrYhVQVh4Npe.Hp3SazZs6IzrC7Piy5lilNhsiFjRAa", "ADMIN");
			//admin1
			urepository.save(user1);
			urepository.save(user2);

			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
