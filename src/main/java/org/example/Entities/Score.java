package org.example.Entities;


import jakarta.persistence.*;

@Entity
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Score")
    private Long id_Score;
    @Column(name = "id_Quiz")
    private Long id_Quiz;

    @Column(name = "id_Student")
    private Long id_Student;
    @Column(name = "score")
    private int score;





    public Score(Long id_Score, Long id_Quiz, Long id_Student) {
       this.id_Quiz=id_Quiz;
       this.id_Score=id_Score;
       this.id_Student=id_Student;
       this.score=100;

    }
    public Score(){

    }

    public Long getId_Score() {
        return id_Score;
    }

    public Long getId_Quiz() {
        return id_Quiz;
    }

    public void setId_Quiz(Long id_Quiz) {
        this.id_Quiz = id_Quiz;
    }

    public Long getId_Student() {
        return id_Student;
    }

    public void setId_Student(Long id_Student) {
        this.id_Student = id_Student;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
