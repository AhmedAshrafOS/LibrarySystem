package com.ashraf.librarysystem.dao;

import com.ashraf.librarysystem.entity.Book;
import com.ashraf.librarysystem.entity.Patron;
import com.ashraf.librarysystem.entity.Records;




public interface RecordDAO {


    void save(Records records);

    Records find(int bookID, int patronID, Book book, Patron patron);
}
