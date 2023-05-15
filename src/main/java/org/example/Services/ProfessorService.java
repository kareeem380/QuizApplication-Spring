package org.example.Services;


import org.example.Entities.Professor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfessorService {
    Professor saveProfessor(Professor professor);

    Professor updateProfessor(Professor professor);

    void deleteProfessor(Long Id);

    Professor getProfessor(Long Id);

    List<Professor> getAllProfessors();

    void deleteAllProfessors();
}
