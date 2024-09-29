package com.ashraf.librarysystem.rest;


import com.ashraf.librarysystem.dao.BookDAO;
import com.ashraf.librarysystem.entity.Book;
import com.ashraf.librarysystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookRestController {

    private BookService bookService;

    @Autowired
    public BookRestController(BookService theBookService){
        bookService = theBookService;
    }

    @GetMapping("/books")
    public List<Book> findAll(){
        return bookService.findAll();
    }


    @GetMapping("/books/{bookId}")
    public Book getBook(@PathVariable int bookId){
        Book theBook = bookService.findByID(bookId);
        if (theBook == null){
            throw new RuntimeException("Book Not Found.."+ bookId);

        }

        return theBook;
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book theBook){
        if(theBook.getId() == 0){
            Book book = bookService.save(theBook);
            return book;
        }
        else {
            Book isBookFound = bookService.findByID(theBook.getId());
            if (isBookFound != null){
                throw new RuntimeException("This Book ID is already attached");
            }

            return bookService.save(theBook);
        }

    }


    @PutMapping("/books/{bookID}")
    public Book updateBook(@PathVariable int bookID,@RequestBody Book theBook){

        Book isBookFound = bookService.findByID(bookID);
        if (isBookFound == null){
            throw new RuntimeException("This Book ID is not found");
        }

        return bookService.save(theBook);
    }


    @DeleteMapping("/books/{bookID}")
    public void deleteBook(@PathVariable int bookID){
        Book tempBook = bookService.findByID(bookID);

        if(tempBook == null){
            throw new RuntimeException("This Book Not found");
        }

        bookService.deleteByID(bookID);
    }


}
