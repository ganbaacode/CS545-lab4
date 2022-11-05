package com.example.lab1.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ExceptionEntity {

    @Id
    @GeneratedValue
    private int id;
    private LocalDate date;
    private String operation;
    private String exceptionType;

}
