package org.example.Entities;


import jakarta.persistence.*;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Quiz")
    private Long id_Quiz;
    @Column(name = "name")
    private String name;
    @Column(name="questionsId")
    private Long questionsId;
    @Column(name="id_Professor")
    private Long id_Professor;
    @Column(name="groupid")
    private Long groupid;


    public Quiz( String name, Long questionsId, Long id_Professor, Long groupid) {

        this.name = name;
        this.questionsId = questionsId;
        this.id_Professor = id_Professor;
        this.groupid = groupid;
    }

    public Quiz(){

    }

    public Long getId_Quiz() {
        return id_Quiz;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQuestionsId() {
        return questionsId;
    }

    public void setQuestionsId(Long questionsId) {
        this.questionsId = questionsId;
    }

    public Long getId_Professor() {
        return id_Professor;
    }

    public void setId_Professor(Long id_Professor) {
        this.id_Professor = id_Professor;
    }

    public Long getGroupid() {
        return groupid;
    }

    public void setGroupid(Long groupid) {
        this.groupid = groupid;
    }
}
