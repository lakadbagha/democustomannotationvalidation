/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo4.dao;

import com.example.demo4.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * Student repository
 */
public interface StudentRepository extends JpaRepository<Student, String> {
    
}
