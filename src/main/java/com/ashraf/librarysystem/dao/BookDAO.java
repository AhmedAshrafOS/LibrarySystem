package com.ashraf.librarysystem.dao;


import com.ashraf.librarysystem.entity.Book;

import java.util.List;

public interface BookDAO {

    List<Book> findAll();

    Book findByID(int theID);

    Book save(Book theBook);

    void deleteByID(int theID);

}
