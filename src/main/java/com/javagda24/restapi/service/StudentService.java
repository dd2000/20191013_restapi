package com.javagda24.restapi.service;

import com.javagda24.restapi.model.Student;
import com.javagda24.restapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Optional<Student> getById(Long studentId){
        return studentRepository.findById(studentId);
    }
}
