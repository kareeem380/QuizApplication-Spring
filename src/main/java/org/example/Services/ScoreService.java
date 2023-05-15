package org.example.Services;

import org.example.Entities.Score;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ScoreService {
    Score saveScore(Score user);

    Score updateScore(Score user);

    void deleteScore(Long Id);

    Score getScore(Long Id);

    List<Score> getAllScores();

    void deleteAllScores();
}
