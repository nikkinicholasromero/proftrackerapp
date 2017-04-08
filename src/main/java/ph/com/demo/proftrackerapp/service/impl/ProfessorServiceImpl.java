package ph.com.demo.proftrackerapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.com.demo.proftrackerapp.domain.Professor;
import ph.com.demo.proftrackerapp.repository.ProfessorRepository;
import ph.com.demo.proftrackerapp.service.ProfessorService;

import java.util.List;

/**
 * Created by nikkiromero on 25/03/2017.
 */
@Service
public class ProfessorServiceImpl implements ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public List<Professor> findAll() {
        return professorRepository.findAll();
    }
}
