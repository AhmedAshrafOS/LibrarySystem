package com.ashraf.librarysystem.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="patron")
public class patron {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id ;

    @Column(name = "name")
    private String name;

    @Column(name = "contactinfo")
    private String contactInfo;

    @Column(name = "borrowedbooks")
    private List<ArrayList> borrowedBooks;

    //Constructors
    public patron(){

    }
    public patron(String name, String contactInfo){
            this.name = name;
            this.contactInfo = contactInfo;
            this.borrowedBooks = new ArrayList<>();


    }
    //Constructors

    //Getter&Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public List<ArrayList> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<ArrayList> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }
    //Getter&Setters


    //toString


    @Override
    public String toString() {
        return "patron{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }
}
