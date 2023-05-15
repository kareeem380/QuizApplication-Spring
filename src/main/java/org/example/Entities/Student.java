package org.example.Entities;


import jakarta.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Student")
    private Long id_Student;
    @Column(name = "name")
    private String name;

    @Column(name = "role")
    private String role;
    @Column(name = "lname")
    private String lname;
    @Column(name = "age")
    private int age;
    @Column(name = "level")
    private int level;
    @Column(name = "groupid")
    private int groupid;



    public Student(String name, String lastName,int level, int age,String role, int groupid) {
        this.name = name;
        this.lname = lastName;
        this.role=role;
        this.level = level;
        this.age = age;
        this.groupid=groupid;

    }
    public Student(){

    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Long getId_Student() {
        return id_Student;
    }

    public void setId_Student(Long id_Student) {
        this.id_Student = id_Student;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }
}
