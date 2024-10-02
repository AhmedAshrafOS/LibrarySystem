package com.ashraf.librarysystem.rest;


import com.ashraf.librarysystem.entity.Book;
import com.ashraf.librarysystem.entity.Patron;
import com.ashraf.librarysystem.service.PatronService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatronRestController {
    private PatronService patronService;

    @Autowired
    public PatronRestController(PatronService thePatronService){
        patronService = thePatronService;
    }



    @GetMapping("/patrons")
    public List<Patron> findAll(){
        return patronService.findAll();
    }


    @GetMapping("/patrons/{patronId}")
    public Patron getPatron(@PathVariable int patronId){
        Patron thePatron = patronService.findByID(patronId);
        if (thePatron == null){
            throw new RuntimeException("Patron Not Found.."+ patronId);

        }

        return thePatron;
    }

    @PostMapping("/patrons")
    public Patron addPatron(@RequestBody Patron thePatron){
        if(thePatron.getId() == 0){
            Patron patron = patronService.save(thePatron);
            return patron;
        }
        else {
            Patron isPatronFound = patronService.findByID(thePatron.getId());
            if (isPatronFound != null){
                throw new RuntimeException("This Patron ID is already attached");
            }

            return patronService.save(thePatron);
        }

    }


    @PutMapping("/patrons/{patronID}")
    public Patron updatePatron(@PathVariable int patronID,@RequestBody Patron thePatron){

        Patron isPatronFound = patronService.findByID(patronID);
        if (isPatronFound == null){
            throw new RuntimeException("This Patron ID is not found");
        }

        return patronService.save(thePatron);
    }


    @DeleteMapping("/patrons/{patronID}")
    public void deleteBook(@PathVariable int patronID){
        Patron tempBook = patronService.findByID(patronID);

        if(tempBook == null){
            throw new RuntimeException("This Patron Not found");
        }

        patronService.deleteByID(patronID);
    }





}
