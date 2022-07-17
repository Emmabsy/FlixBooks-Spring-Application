package com.BookStore.FlixBooks.Store;

import com.BookStore.FlixBooks.Store.model.Book;
import com.BookStore.FlixBooks.Store.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlixBooksStoreApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FlixBooksStoreApplication.class, args);
	}
	@Autowired
	private BookRepo bookRepo;
	@Override
	public void run(String... args) throws Exception {
		/* Book book1=new Book("Emma", "Press", "Machine Learning", "London",
				 6000, "Computing",2010);
		 bookRepo.save(book1);
		Book book2=new Book("King", "May", "Aliens", "Newyork",
				4000, "Cosmos",2008);
		bookRepo.save(book2);

		Book book3=new Book("Queen", "Sane", "Artificial Intelligence", "Logman",
				5000, "Computing",2008);
		bookRepo.save(book3);
		Book book4=new Book("Mason", "Cliff",
				"Football AI", "Fifa",
				2000, "Football",2020);
		bookRepo.save(book4);*/

	}
}
