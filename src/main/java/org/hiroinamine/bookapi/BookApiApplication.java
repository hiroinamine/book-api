package org.hiroinamine.bookapi;

import org.hiroinamine.bookapi.models.Book;
import org.hiroinamine.bookapi.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookApiApplication implements CommandLineRunner {

	@Autowired
	private BookService service;

	public static void main(String[] args) {
		SpringApplication.run(BookApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/**
		 * Setup com dados iniciais na base de dados
		 */
		service.deleteAll();
		service.insert(new Book(null, "O pequeno príncipe", "Google Books", "ficção", 1943));
		service.insert(new Book(null, "O Hobbit", "HarperCollins", "fantasia", 2019));
		service.insert(new Book(null, "2001: Uma odisséia no espaço", "Aleph", "ficção", 2013));
		service.insert(new Book(null, "Pai rico, pai pobre", "Alta Books", "finanças", 2017));
		service.insert(new Book(null, "O iluminado", "Albuquerque", "terror", 2012));
	}

}
