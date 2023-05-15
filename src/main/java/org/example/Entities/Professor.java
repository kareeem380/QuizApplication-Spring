package org.example.Entities;


import jakarta.persistence.*;

@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Professor")
    private Long id_Professor;
    @Column(name = "role")
    private String role;
    @Column(name = "name")
    private String name;
    @Column(name = "lName")
    private String lName;

    public Professor(String name, String lastName,String role) {
        this.name = name;
        this.lName = lastName;
        this.role=role;
    }
    public Professor(){

    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getId_Professor() {
        return id_Professor;
    }

    public void setId_Professor(Long id_Student) {
        this.id_Professor = id_Student;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

}
