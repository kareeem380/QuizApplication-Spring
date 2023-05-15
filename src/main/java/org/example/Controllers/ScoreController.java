package org.example.Controllers;

import org.example.Entities.Score;
import org.example.Repositories.ScoreRepository;
import org.example.Services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScoreController implements ScoreService {
    @Autowired
    ScoreRepository repositry;
    @PostMapping("/score")
    public Score saveScore(@RequestBody Score score) {
        return repositry.save(score);
    }

    @PutMapping("/score")
    public Score updateScore(@RequestBody Score score) {
        return repositry.save(score);
    }


    @DeleteMapping("/score/{id}")
    public void deleteScore(@PathVariable Long Id) {
            repositry.deleteById(Id);
    }

    @GetMapping("/score/{id}")
    public Score getScore(@PathVariable Long Id) {
        return repositry.findById(Id).orElse(null);
    }

    @GetMapping("/scores")
    public List<Score> getAllScores() {
        return repositry.findAll();
    }

    @DeleteMapping("/scores")
    public void deleteAllScores() {
        repositry.deleteAll();
    }
}