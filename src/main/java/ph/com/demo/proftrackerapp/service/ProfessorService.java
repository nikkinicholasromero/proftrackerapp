package ph.com.demo.proftrackerapp.service;

import ph.com.demo.proftrackerapp.domain.Professor;

import java.util.List;

/**
 * Created by nikkiromero on 23/03/2017.
 */
public interface ProfessorService {
    void create(Professor professor);
    void update(Professor professor);
    void delete(Professor professor);
    Professor findOneByProfessorId(String professorId);
    List<Professor> findAll();
}
