package com.ashraf.librarysystem.dao;


import com.ashraf.librarysystem.entity.Book;
import com.ashraf.librarysystem.entity.Patron;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatronDAOImpl implements PatronDAO{

    private EntityManager entityManager;

    @Autowired
    public PatronDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }


    @Override
    public List<Patron> findAll() {
        TypedQuery<Patron> theQuery = entityManager.createQuery("from Patron", Patron.class);

        return theQuery.getResultList();
    }

    @Override
    public Patron findByID(int theID) {
        return entityManager.find(Patron.class,theID);
    }

    @Override
    public Patron save(Patron thePatron) {
        return entityManager.merge(thePatron);
    }

    @Override
    public void deleteByID(int theID) {
        Patron thePatron =  entityManager.find(Patron.class,theID);
        entityManager.remove(thePatron);
    }
}
