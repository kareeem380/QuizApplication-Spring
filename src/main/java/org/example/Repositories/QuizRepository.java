package org.example.Repositories;

import org.example.Entities.Question;
import org.example.Entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    @Query("SELECT q FROM Quiz q LEFT JOIN FETCH q.questions WHERE q.id_Quiz = :id")
    Optional<Quiz> findByIdWithQuestions(@Param("id") Long id);
}

