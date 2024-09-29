package com.ashraf.librarysystem.entity;


import jakarta.persistence.*;

@Entity
@Table(name="book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id ;

    @Column(name = "title")
    private String title;

    @Column(name = "year")
    private int year;

    @Column(name = "isbn")
    private String isbn;

    //Constructors
    public Book(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book(String title, int year, String isbn){
        this.title = title;
        this.year = year;
        this.isbn = isbn;
        this.id = 0;
    }

    //Constructors


    //Getters&Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    //Getters&Setters

    //toString


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
