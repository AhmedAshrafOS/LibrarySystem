package com.ashraf.librarysystem.service;

import com.ashraf.librarysystem.dao.BookDAO;
import com.ashraf.librarysystem.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    private BookDAO bookDAO;

    @Autowired
    public BookServiceImpl(BookDAO theBookDAO){
        bookDAO = theBookDAO;
    }

    @Override
    public List<Book> findAll() {
        return bookDAO.findAll();
    }

    @Override
    public Book findByID(int theID) {
        return bookDAO.findByID(theID);
    }

    @Transactional
    @Override
    public Book save(Book theBook) {
        return bookDAO.save(theBook);
    }

    @Transactional
    @Override
    public void deleteByID(int theID) {
        bookDAO.deleteByID(theID);
    }


}



