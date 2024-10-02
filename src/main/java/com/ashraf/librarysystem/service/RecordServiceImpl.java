package com.ashraf.librarysystem.service;


import com.ashraf.librarysystem.dao.RecordDAO;
import com.ashraf.librarysystem.dao.RecordDAOImpl;
import com.ashraf.librarysystem.entity.Book;
import com.ashraf.librarysystem.entity.Patron;
import com.ashraf.librarysystem.entity.Records;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecordServiceImpl implements RecordService {
    private RecordDAO recordDAO;
    private BookService bookService;
    private PatronService patronService;

    @Autowired
    public RecordServiceImpl(RecordDAO recordDAO, BookService bookService, PatronService patronService){
            this.recordDAO = recordDAO;
            this.bookService = bookService;
            this.patronService = patronService;
    }

    @Override
    @Transactional
    public void save(Records records) {
        recordDAO.save(records);
    }

    @Override
    public Records find(int bookID, int patronID) {
        Book tempBook = bookService.findByID(bookID);
        Patron tempPatron = patronService.findByID(patronID);
        return recordDAO.find(bookID,patronID,tempBook,tempPatron);
    }
}
