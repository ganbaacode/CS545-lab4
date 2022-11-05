package com.example.lab1.Aspect;

import com.example.lab1.entity.ExceptionEntity;
import com.example.lab1.service.ExceptionService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Aspect
@Component
public class ExceptionLogger {

    @Autowired
    private ExceptionService exceptionService;



    @AfterThrowing(pointcut = "@annotation(com.example.lab1.Aspect.annotation.ExceptionLoggerAnnotation)", throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception) {

        //populating Exception object
        LocalDate date = LocalDate.now();
        String operation = joinPoint.getSignature().getName()+" method";
        String type = exception.toString();
        ExceptionEntity myException = new ExceptionEntity(0,date,operation,type);
        exceptionService.save(myException);
        System.out.println("Exception logger ran...");
    }


}
