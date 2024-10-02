package com.ashraf.librarysystem;

import com.ashraf.librarysystem.dao.BookDAO;
import com.ashraf.librarysystem.entity.Book;
import com.ashraf.librarysystem.service.BookService;
import com.ashraf.librarysystem.service.BookServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class BookServiceTest {


    @Mock
    private BookDAO bookDAO;

    @InjectMocks
    private BookServiceImpl bookService;

    @BeforeEach
    public void beforeEach(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testFindAll(){
        List<Book> books = new ArrayList<>();
        books.add(new Book("test",2000,"123123"));

        Mockito.when(bookDAO.findAll()).thenReturn(books);
//        Mockito.when(bookDAO.findAll()).thenReturn(tempBook).thenReturn(tempBook);


        List<Book> responseBooks = bookService.findAll();

        Assertions.assertNotNull(responseBooks,"Not Null");
        Assertions.assertFalse(responseBooks.isEmpty());


    }

    @Test
    public void testFindByID(){
        Book book = new Book("Test",2000,"qweqwe");
        book.setId(3);
        Mockito.when(bookDAO.findByID(3)).thenReturn(book);

        Book responseBook = bookService.findByID(3);

        Assertions.assertNotNull(responseBook,"Not Null");
        Assertions.assertEquals(responseBook.getId(), 3);

    }





}
