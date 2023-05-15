package org.example.Services;

import org.example.Entities.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService {

    Question saveQuestion(Question question);
    Question updateQuestion(Question question);
    void deleteQuestion(Long Id);
    Question getQuestion(Long Id);
    List<Question> getAllQuestions();
    void deleteAllQuestions();
}
