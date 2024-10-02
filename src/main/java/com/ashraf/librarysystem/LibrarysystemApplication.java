package com.ashraf.librarysystem;

import com.ashraf.librarysystem.dao.BookDAO;
import com.ashraf.librarysystem.dao.RecordDAO;
import com.ashraf.librarysystem.entity.Book;
import com.ashraf.librarysystem.entity.Patron;
import com.ashraf.librarysystem.entity.Records;
import com.ashraf.librarysystem.service.BookService;
import com.ashraf.librarysystem.service.PatronService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.parameters.P;

import java.util.Date;

@SpringBootApplication
public class LibrarysystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrarysystemApplication.class, args);
	}


}
