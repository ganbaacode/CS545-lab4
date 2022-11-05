package com.example.lab1.Aspect;

import com.example.lab1.entity.Logger;
import com.example.lab1.repo.LoggerRepo;
import com.example.lab1.service.LoggerService;
import com.example.lab1.service.UserService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Aspect
@Component
public class ExecutionTimeAspect {

    @Autowired
    private LoggerService loggerService;


    @Pointcut("@annotation(com.example.lab1.Aspect.annotation.ExectutionTime)")
    public void executionTimeAnnotation(){

    }


    @Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();
        System.out.println(proceedingJoinPoint.getSignature().getName() + " takes ns: " + (finish - start));

        //populating Logger object
        LocalDate curDate = LocalDate.now();
        String principle = proceedingJoinPoint.getSignature().getName();
        String operation = " takes ns: " + (finish - start);
        Logger myLog = new Logger(1,curDate,principle,operation);
        loggerService.saveLog(myLog);
        return result;


    }




}
