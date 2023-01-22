package com.example.crudbook;

import com.example.crudbook.model.Book;
import com.example.crudbook.repository.RepoBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudbookApplication.class, args);

		Book book = new Book();

		book.setId(1L);
		book.setTitle("libro 1");
		book.setDec("buen libro");
	}

}
