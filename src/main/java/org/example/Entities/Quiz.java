package org.example.Entities;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Quiz")
    private Long id_Quiz;
    @Column(name = "name")
    private String name;
    @Column(name="id_Professor")
    private Long id_Professor;
    @Column(name="groupid")
    private Long groupid;
    @OneToMany(mappedBy = "quiz")
    private List<Question> questions = new ArrayList<>();

    @OneToOne(mappedBy = "quiz")
    private Score score;

    public Quiz(Long id_Quiz, String name, Long id_Professor, Long groupid, List<Question> questions) {
        this.id_Quiz = id_Quiz;
        this.name = name;
        this.id_Professor = id_Professor;
        this.groupid = groupid;
        this.questions = questions;
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
