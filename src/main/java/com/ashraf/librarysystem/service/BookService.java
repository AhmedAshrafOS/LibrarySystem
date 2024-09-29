package com.ashraf.librarysystem.service;

import com.ashraf.librarysystem.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book findByID(int theID);

    Book save(Book theBook);

    void deleteByID(int theID);

}
