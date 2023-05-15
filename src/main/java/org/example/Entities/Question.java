package org.example.Entities;


import jakarta.persistence.*;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Question")
    private Long id_Question;
    @Column(name = "question")
    private String question;
    @Column(name="rep1")
    private String rep1;
    @Column(name="rep2")
    private String rep2;
    @Column(name="rep3")
    private String rep3;
    @Column(name="repCorr")
    private String repCorr;

    public Question(String question, String rep1,String rep2,String rep3, String repCorr ) {
        this.question = question;
        this.rep1 = rep1;
        this.rep2=rep2;
        this.rep3 = rep3;
        this.repCorr = repCorr;

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

    public String getRepCorr() {
        return repCorr;
    }

    public void setRepCorr(String repCorr) {
        this.repCorr = repCorr;
    }

    public Question(){

    }


}
