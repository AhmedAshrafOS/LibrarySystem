package com.ashraf.librarysystem.dao;

import com.ashraf.librarysystem.entity.Book;
import com.ashraf.librarysystem.entity.Patron;

import java.util.List;

public interface PatronDAO {

    List<Patron> findAll();

    Patron findByID(int theID);

    Patron save(Patron thePatron);

    void deleteByID(int theID);

}
