/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo4.controller;

import com.example.demo4.AgeValidator;
import com.example.demo4.dao.StudentRepository;
import com.example.demo4.model.Student;
import com.example.demo4.pojo.ResponseData;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * Student Controller
 */
@Controller
public class StudentController {

    @Autowired
    private StudentRepository repository;

    @PostMapping("/send")
    public ResponseEntity saveStudent(@Validated @RequestBody Student student) {
        System.out.println("saveStudent invoked");
        repository.save(student);
        ResponseData responseData = new ResponseData();
        responseData.setResultId("result");
        responseData.setResultValue("saved");
        ResponseEntity entity = new ResponseEntity(responseData, HttpStatus.OK);
        return entity;
    }

    @GetMapping("/reg-form")
    public String getRegisterForm() {
        return "register";
    }

    @ResponseBody
    @GetMapping("/stu-list")
    public List<Student> getAllStudent() {
        List<Student> list = repository.findAll();
        return list;
    }

    @GetMapping("/delete-all")
    public ResponseEntity deleteAll() {
        repository.deleteAll();
        ResponseData responseData = new ResponseData();
        responseData.setResultId("result");
        responseData.setResultValue("deleted");
        ResponseEntity entity = new ResponseEntity(responseData, HttpStatus.OK);
        return entity;
    }
}
