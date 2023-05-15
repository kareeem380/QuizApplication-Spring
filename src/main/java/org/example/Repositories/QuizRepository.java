package org.example.Repositories;

import org.example.Entities.Question;
import org.example.Entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
