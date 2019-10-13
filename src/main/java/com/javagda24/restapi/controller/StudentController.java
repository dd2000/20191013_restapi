package com.javagda24.restapi.controller;

import com.javagda24.restapi.model.Student;
import com.javagda24.restapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
public class StudentController {

    @GetMapping("/get")
    public Student getStudent(){
        Student student = new Student();
        student.setFirstName("Marian");
        student.setLastName("Marianski");

        student.setBirthDate(LocalDate.of(1990,03,03));
        student.setId(3L); // pole Id ma wartość 3
        // pozostałe 2 pola nie zostały ustawione

        return student;
    }

    // 1 stwórz GET Mapping na adres /get/{id} - powinien zwracać i wyświetlać studenta z bazy danych
    @Autowired
    private StudentService studentService;

    @GetMapping("/get/{id}")
/*  wersja pierwotna
    public Student getByPathVariable(@PathVariable("id") Long studentId){
        Optional<Student> studentOptional = studentService.getById(studentId);
        if (studentOptional.isPresent()){
            return studentOptional.get();
        }
        return null;
    }
*/
    public ResponseEntity<Student> getByPathVariable(@PathVariable("id") Long studentId){
        Optional<Student> studentOptional = studentService.getById(studentId);
        if (studentOptional.isPresent()){
            return ResponseEntity.ok(studentOptional.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    // 2 stwórz GET Mapping na adres /get?studentId=1 - powinien zwracać i wyświetlać studenta z bazy danych
    @GetMapping("/get")
    //public Student getByRequestParam(@RequestParam("studentId") Long studentId){
    public ResponseEntity<Student> getByRequestParam(@RequestParam("studentId") Long studentId){
        Optional<Student> studentOptional = studentService.getById(studentId);
        if (studentOptional.isPresent()){
            return ResponseEntity.ok(studentOptional.get());
        }
        //return null;
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    // C      R      U      D
    // PUT    GET    POST   DELETE
    //POST
    @PutMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void insertStudent(@RequestBody Student student){
        studentService.insertIntoDatabase(student);
    }
}
