package org.example.Services;

import org.example.Entities.Question;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface QuestionService {

    Question saveQuestion(Question question, Long quizId) throws ChangeSetPersister.NotFoundException;
    Question updateQuestion(Question question);
    void deleteQuestion(Long Id);
    ResponseEntity<Map<String, Object>> getQuestion(Long Id);
    List<Question> getAllQuestions();
    void deleteAllQuestions();
}
