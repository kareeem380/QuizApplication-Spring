package org.example.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_question")
    private Long idQuestion;

    @Column(name = "question")
    private String question;

    @Column(name = "rep1")
    private String rep1;

    @Column(name = "rep2")
    private String rep2;

    @Column(name = "rep3")
    private String rep3;

    @Column(name = "correct_rep")
    private String correctRep;

    @ManyToOne()
    @JoinColumn(name="id_Quiz")
    private Quiz quiz;

    public Question(String question, String rep1, String rep2, String rep3, String correctRep, Quiz quiz) {
        this.question = question;
        this.rep1 = rep1;
        this.rep2 = rep2;
        this.rep3 = rep3;
        this.correctRep = correctRep;
        this.quiz = quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Question(){

    }

    public Long getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Long idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getRep1() {
        return rep1;
    }

    public void setRep1(String rep1) {
        this.rep1 = rep1;
    }

    public String getRep2() {
        return rep2;
    }

    public void setRep2(String rep2) {
        this.rep2 = rep2;
    }

    public String getRep3() {
        return rep3;
    }

    public void setRep3(String rep3) {
        this.rep3 = rep3;
    }

    public String getCorrectRep() {
        return correctRep;
    }

    public void setCorrectRep(String correctRep) {
        this.correctRep = correctRep;
    }
    public Long getQuizId() {
        if (quiz != null) {
            return quiz.getId_Quiz();
        } else {
            return null;
        }
    }
}
