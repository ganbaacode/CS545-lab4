package com.example.lab1.repo;

import com.example.lab1.entity.Logger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggerRepo extends JpaRepository<Logger,Integer> {
}
