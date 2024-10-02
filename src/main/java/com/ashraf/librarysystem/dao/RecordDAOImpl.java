package com.ashraf.librarysystem.dao;

import com.ashraf.librarysystem.entity.Book;
import com.ashraf.librarysystem.entity.Patron;
import com.ashraf.librarysystem.entity.Records;
import com.ashraf.librarysystem.service.BookService;
import com.ashraf.librarysystem.service.PatronService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.QueryHint;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class RecordDAOImpl implements RecordDAO{

    private EntityManager entityManager;

    @Autowired
    public RecordDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;

    }

    @Override
    public void save(Records records) {
        entityManager.persist(records);
    }

    @Override
    public Records find(int bookId, int patronId, Book tempBook, Patron tempPatron) {

        String hql = "SELECT r FROM Records r WHERE r.book = :bookId AND r.patron = :patronId";
        TypedQuery<Records> query = entityManager.createQuery(hql, Records.class);
        query.setParameter("bookId", tempBook);
        query.setParameter("patronId", tempPatron);
        return query.getResultList().getFirst();
    }


}
