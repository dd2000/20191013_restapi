package com.javagda24.restapi.controller;

import com.javagda24.restapi.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/get")
    public Student getStudent(){
        Student student = new Student();
        student.setFirstName("Marian");
        student.setLastName("Marianski");
        student.setId(3L);

        return student;
    }
}
