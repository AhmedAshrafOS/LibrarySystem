package com.ashraf.librarysystem.service;



import com.ashraf.librarysystem.entity.Patron;

import java.util.List;

public interface PatronService {

    List<Patron> findAll();

    Patron findByID(int theID);

    Patron save(Patron thePatron);

    void deleteByID(int theID);
}
