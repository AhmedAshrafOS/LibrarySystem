package com.ashraf.librarysystem.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="patron")
public class Patron {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id ;

    @Column(name = "name")
    private String name;

    @Column(name = "contactinfo")
    private String contactInfo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "patron")
    private List<Records> borrowedBooks;

    public List<Records> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Records> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    //Constructors
    public Patron(){

    }
    public Patron(String name, String contactInfo){
            this.name = name;
            this.contactInfo = contactInfo;
            this.borrowedBooks = new ArrayList<>();
            this.id = 0;

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
