package org.example.Entities;


import jakarta.persistence.*;

@Entity
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Score")
    private Long id_Score;
    @Column(name = "score")
    private int score;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Quiz", referencedColumnName = "id_Quiz")
    private Quiz quiz;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Student", referencedColumnName = "id_Student")
    private Student student;




    public Score(Long id_Score, Student student, Quiz quiz) {
       this.student=student;
       this.quiz=quiz;
       this.id_Score=id_Score;
       this.score=100;
    }
    public Score(){

    }

    public Long getId_Score() {
        return id_Score;
    }

    public void setId_Score(Long id_Score) {
        this.id_Score = id_Score;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
