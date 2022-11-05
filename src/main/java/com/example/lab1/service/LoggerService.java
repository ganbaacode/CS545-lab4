package com.example.lab1.service;

import com.example.lab1.entity.Logger;
import com.example.lab1.repo.LoggerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggerService {

    @Autowired
    private LoggerRepo loggerRepo;

    public void saveLog(Logger log){
        loggerRepo.save(log);
    }
}
