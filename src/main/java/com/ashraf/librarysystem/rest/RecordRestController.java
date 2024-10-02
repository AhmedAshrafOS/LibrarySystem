package com.ashraf.librarysystem.rest;


import com.ashraf.librarysystem.entity.Book;
import com.ashraf.librarysystem.entity.Patron;
import com.ashraf.librarysystem.entity.Records;
import com.ashraf.librarysystem.service.BookService;
import com.ashraf.librarysystem.service.PatronService;
import com.ashraf.librarysystem.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class RecordRestController {
    private RecordService recordService;
    private BookService bookService;
    private PatronService patronService;

    @Autowired
    public RecordRestController(RecordService recordService, BookService bookService, PatronService patronService){
        this.recordService = recordService;
        this.bookService = bookService;
        this.patronService = patronService;
    }

    @PostMapping("/api/record/{bookId}/patron/{patronId}")
    public void borrowBook(@PathVariable int bookId,@PathVariable int patronId){
        Book tempBook = bookService.findByID(bookId);
        Patron tempPatron = patronService.findByID(patronId);
        if ( tempBook == null)  {
            throw new RuntimeException("This Book Not Found");
        }

        if (tempPatron == null)  {
            throw new RuntimeException("This Patron Not Found");
        }
         recordService.save(new Records(tempPatron, tempBook, new Date(System.currentTimeMillis()), null));
        System.out.println("ADD Done");
    }


    @PutMapping("/api/record/{bookId}/patron/{patronId}")
    public void returnBook(@PathVariable int bookId,@PathVariable int patronId){
        Book tempBook = bookService.findByID(bookId);
        Patron tempPatron = patronService.findByID(patronId);
        if ( tempBook == null)  {
            throw new RuntimeException("This Book Not Found");
        }

        if (tempPatron == null)  {
            throw new RuntimeException("This Patron Not Found");
        }
        Records tempRecord =  recordService.find(bookId,patronId);

        if (tempRecord == null)  {
            throw new RuntimeException("This Record Not Found");
        }
        tempRecord.setReturnDate(new Date(System.currentTimeMillis()));
        recordService.save(tempRecord);
        System.out.println("Return Done");
    }

}
