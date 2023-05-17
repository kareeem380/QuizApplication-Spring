package org.example.Services;

import org.example.Entities.Quiz;
import org.example.Entities.Score;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public interface QuizService {
    Quiz saveQuiz(Quiz quiz);

    Quiz updateQuiz(Quiz quiz);

    void deleteQuiz(Long Id);

    ResponseEntity<Quiz> getQuiz(Long Id);

    List<Quiz> getAllQuizs();

    void deleteAllQuizs();
}
