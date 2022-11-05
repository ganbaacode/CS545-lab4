package com.example.lab1.repo;

import com.example.lab1.entity.ExceptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExceptionRepo extends JpaRepository <ExceptionEntity,Integer>{
}
