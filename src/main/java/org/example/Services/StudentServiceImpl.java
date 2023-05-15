package org.example.Services;

import org.example.Entities.Student;
import org.example.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepository repositry;
    @PostMapping("/student")
    public Student saveStudent(@RequestBody Student student){
        return repositry.save(student);
    };
    @PutMapping("/student")
    public Student updateStudent(@RequestBody Student student){
        return repositry.save(student);
    };
    @DeleteMapping("/student/{id}")
    public  void deleteStudent(@PathVariable Long id){
        repositry.deleteById(id);
    };
    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable Long id){
        return repositry.findById(id).orElse(null);
    };
    @GetMapping("/students")
    public  List <Student> getAllStudents(){
        return repositry.findAll();
    };
    @DeleteMapping("/student")
    public  void deleteAllStudents(){
        repositry.deleteAll();
    };
}