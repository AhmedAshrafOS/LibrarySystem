package com.ashraf.librarysystem.entity;


import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name="records")
public class Records {
    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="book_id")
    private Book book;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="patron_id")
    private Patron patron;

    @Column(name="return_date")
    private Date returnDate;


    @Column(name="borrowing_date")
    private Date borrowingDate;
    public Records(){

    }
    public Records(Patron patron, Book book,  Date borrowingDate,Date returnDate) {
        this.patron = patron ;
        this.book =book;
        this.returnDate = returnDate;
        this.borrowingDate = borrowingDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Patron getPatron() {
        return patron;
    }

    public void setPatron(Patron patron) {
        this.patron = patron;
    }






    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate(Date borrowingDate) {
        this.borrowingDate = borrowingDate;
    }

    @Override
    public String toString() {
        return "Records{" +
                ", returnDate=" + returnDate +
                ", borrowingDate=" + borrowingDate +
                '}';
    }
}
