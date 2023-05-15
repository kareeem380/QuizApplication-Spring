package org.example.Services;


import org.example.Entities.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    Student saveStudent(Student student);

    Student updateStudent(Student student);

    void deleteStudent(Long Id);

    Student getStudent(Long Id);

    List<Student> getAllStudents();

    void deleteAllStudents();
}
