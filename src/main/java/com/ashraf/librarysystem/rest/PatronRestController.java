package com.ashraf.librarysystem.rest;


import com.ashraf.librarysystem.service.PatronService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatronRestController {
    private PatronService patronService;

    @Autowired
    public PatronRestController(PatronService thePatronService){
        patronService = thePatronService;
    }

}
