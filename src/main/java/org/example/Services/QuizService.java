package org.example.Services;

import org.example.Entities.Quiz;
import org.example.Entities.Score;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public interface QuizService {
    Quiz saveQuiz(Quiz quiz);

    Quiz updateQuiz(Quiz quiz);

    void deleteQuiz(Long Id);

    Quiz getQuiz(Long Id);

    List<Quiz> getAllQuizs();

    void deleteAllQuizs();
}
