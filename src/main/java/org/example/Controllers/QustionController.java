package org.example.Controllers;

import org.example.Entities.Question;
import org.example.Repositories.QuestionRepository;
import org.example.Services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QustionController implements QuestionService {
    @Autowired
    QuestionRepository repositry;
    @PostMapping("/question")
    public Question saveQuestion(@RequestBody Question question){
        return repositry.save(question);
    };
    @PutMapping("/question")
    public Question updateQuestion(@RequestBody Question question){
        return repositry.save(question);
    };
    @DeleteMapping("/question/{id}")
    public  void deleteQuestion(@PathVariable Long id){
        repositry.deleteById(id);
    };
    @GetMapping("/question/{id}")
    public Question getQuestion(@PathVariable Long id){
        return repositry.findById(id).orElse(null);
    };
    @GetMapping("/questions")
    public List<Question> getAllQuestions(){
        return repositry.findAll();
    };
    @DeleteMapping("/questions")
    public  void deleteAllQuestions(){
        repositry.deleteAll();
    };

}
