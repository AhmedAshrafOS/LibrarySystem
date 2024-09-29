package com.ashraf.librarysystem.dao;


import com.ashraf.librarysystem.entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class BookDAOImpl implements BookDAO {

    private EntityManager entityManager;

    @Autowired
    public BookDAOImpl(EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }


    @Override
    public List<Book> findAll() {
        TypedQuery<Book> theQuery = entityManager.createQuery("from Book", Book.class);

        return theQuery.getResultList();
    }

    @Override
    public Book findByID(int theID) {

        return entityManager.find(Book.class,theID);
    }

    @Override
    public Book save(Book theBook) {
        return entityManager.merge(theBook);
    }

    @Override
    public void deleteByID(int theID) {
        Book theBook = entityManager.find(Book.class,theID);
        entityManager.remove(theBook);
    }


}
