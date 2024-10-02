package com.ashraf.librarysystem.service;


import com.ashraf.librarysystem.dao.PatronDAO;
import com.ashraf.librarysystem.entity.Patron;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PatronServiceImpl implements PatronService {

    private PatronDAO patronDAO;

    @Autowired
    public PatronServiceImpl(PatronDAO thePatronDAO){
        patronDAO = thePatronDAO;
    }

    @Override
    public List<Patron> findAll() {
        return patronDAO.findAll();
    }

    @Override
    public Patron findByID(int theID) {
        return patronDAO.findByID(theID);
    }


    @Transactional
    @Override
    public Patron save(Patron thePatron) {
        return patronDAO.save(thePatron);
    }

    @Transactional
    @Override
    public void deleteByID(int theID) {
        patronDAO.deleteByID(theID);
    }
}
