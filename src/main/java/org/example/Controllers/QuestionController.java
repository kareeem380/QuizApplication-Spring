package org.example.Controllers;

import org.example.Entities.Question;
import org.example.Entities.Quiz;
import org.example.Repositories.QuestionRepository;
import org.example.Repositories.QuizRepository;
import org.example.Services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class QuestionController implements QuestionService {
    @Autowired
    QuestionRepository repositry;
    QuizRepository repositryQuiz;
    @Autowired
    QuizController quizController;
    Quiz quiz;
    @PostMapping("/question/{quizId}")
    public Question saveQuestion(@RequestBody Question question, @PathVariable Long quizId)  {
        quiz = quizController.getQuiz(quizId).getBody();
        if(quiz==null){
            throw new RuntimeException("quiz Not found");
        }
        else {
            question.setQuiz(quiz);
            return repositry.save(question);
        }

    }

    @PutMapping("/question")
    public Question updateQuestion(@RequestBody Question question){
        return repositry.save(question);
    };
    @DeleteMapping("/question/{id}")
    public  void deleteQuestion(@PathVariable Long id){
        repositry.deleteById(id);
    };
    @GetMapping("/question/{id}")
    public ResponseEntity<Map<String, Object>> getQuestion(@PathVariable Long id) {
        Question question = repositry.findById(id).orElse(null);

        if (question == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("idQuestion", question.getIdQuestion());
        response.put("question", question.getQuestion());
        response.put("rep1", question.getRep1());
        response.put("rep2", question.getRep2());
        response.put("rep3", question.getRep3());
        response.put("correctRep", question.getCorrectRep());
        response.put("idQuiz", question.getQuizId());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/questions")
    public List<Question> getAllQuestions(){
        return repositry.findAll();
    };
    @DeleteMapping("/questions")
    public  void deleteAllQuestions(){
        repositry.deleteAll();
    };

}
