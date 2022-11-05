package com.example.lab1.service;

import com.example.lab1.entity.ExceptionEntity;
import com.example.lab1.repo.ExceptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExceptionService {

    @Autowired
    private ExceptionRepo exceptionRepo;

    public void save(ExceptionEntity e){
        exceptionRepo.save(e);
    }
}
