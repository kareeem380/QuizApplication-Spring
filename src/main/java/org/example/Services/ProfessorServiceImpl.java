package org.example.Services;

import org.example.Entities.Professor;
import org.example.Repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfessorServiceImpl implements ProfessorService{
    @Autowired
    ProfessorRepository repositry;
    @PostMapping("/professor")
    public Professor saveProfessor(@RequestBody Professor professor){
        return repositry.save(professor);
    };
    @PutMapping("/professor")
    public Professor updateProfessor(@RequestBody Professor professor){
        return repositry.save(professor);
    };
    @DeleteMapping("/professor/{id}")
    public  void deleteProfessor(@PathVariable Long id){
        repositry.deleteById(id);
    };
    @GetMapping("/professor/{id}")
    public Professor getProfessor(@PathVariable Long id){
        return repositry.findById(id).orElse(null);
    };
    @GetMapping("/professors")
    public  List <Professor> getAllProfessors(){
        return repositry.findAll();
    };
    @DeleteMapping("/professor")
    public  void deleteAllProfessors(){
        repositry.deleteAll();
    };
}