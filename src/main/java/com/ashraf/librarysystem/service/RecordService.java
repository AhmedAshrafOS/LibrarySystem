package com.ashraf.librarysystem.service;


import com.ashraf.librarysystem.entity.Records;



public interface RecordService {


    void save(Records records);

    Records find(int bookID, int patronID);
}
