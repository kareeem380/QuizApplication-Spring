package org.example.Controllers;

import org.example.Entities.Quiz;
import org.example.Repositories.QuestionRepository;
import org.example.Repositories.QuizRepository;
import org.example.Services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuizController implements QuizService {
    @Autowired
    QuizRepository repositry;
    @PostMapping("/quiz")
    public Quiz saveQuiz(@RequestBody Quiz quiz) {
        return repositry.save(quiz);
    }

    @PutMapping("/quiz")
    public Quiz updateQuiz(@RequestBody Quiz quiz) {
        return repositry.save(quiz);
    }

    @DeleteMapping("/quiz/{id}")
    public void deleteQuiz(@PathVariable Long Id) {
        repositry.deleteById(Id);
    }

    @GetMapping("/quiz/{id}")
    public Quiz getQuiz(Long Id) {
        return repositry.findById(Id).orElse(null);
    }

    @GetMapping("/quizs")
    public List<Quiz> getAllQuizs() {
        return repositry.findAll();
    }

    @DeleteMapping("/quiz")
    public void deleteAllQuizs() {
        repositry.deleteAll();
    }
}
