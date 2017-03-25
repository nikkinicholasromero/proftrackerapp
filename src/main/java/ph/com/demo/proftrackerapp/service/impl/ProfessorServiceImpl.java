package ph.com.demo.proftrackerapp.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.com.demo.proftrackerapp.domain.Professor;
import ph.com.demo.proftrackerapp.exception.ExceptionConstants;
import ph.com.demo.proftrackerapp.exception.ProfTrackerAppException;
import ph.com.demo.proftrackerapp.repository.ProfessorRepository;
import ph.com.demo.proftrackerapp.service.ProfessorService;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by nikkiromero on 25/03/2017.
 */
@Service
public class ProfessorServiceImpl implements ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public void create(Professor professor) {
        validateProfessor(professor);

        Professor targetProfessor = professorRepository.findOneByProfessorIdAndDeleted(professor.getProfessorId(), false);
        if (targetProfessor != null) {
            throw new ProfTrackerAppException(ExceptionConstants.PROFESSOR_ALREADY_EXISTS);
        } else {
            professor.setDeleted(false);
            professor.setDateCreated(LocalDateTime.now());
            professor.setDateModified(LocalDateTime.now());
            professor.setRevisionNumber(1);
            professorRepository.save(professor);
        }
    }

    public void update(Professor professor) {
        validateProfessor(professor);

        Professor targetProfessor = professorRepository.findOneByProfessorIdAndDeleted(professor.getProfessorId(), false);

        if (targetProfessor == null) {
            throw new ProfTrackerAppException(ExceptionConstants.PROFESSOR_DOES_NOT_EXIST);
        } else if (professor.getRevisionNumber() < targetProfessor.getRevisionNumber()) {
            throw new ProfTrackerAppException(ExceptionConstants.PROFESSOR_RECORD_IS_OUTDATED);
        } else {
            if (StringUtils.isNotEmpty(professor.getProfessorId())) {
                targetProfessor.setProfessorId(professor.getProfessorId());
            }
            if (StringUtils.isNotEmpty(professor.getFirstName())) {
                targetProfessor.setFirstName(professor.getFirstName());
            }
            if (StringUtils.isNotEmpty(professor.getMiddleName())) {
                targetProfessor.setMiddleName(professor.getMiddleName());
            }
            if (StringUtils.isNotEmpty(professor.getLastName())) {
                targetProfessor.setLastName(professor.getLastName());
            }
            if (professor.getBirthDate() != null) {
                targetProfessor.setBirthDate(professor.getBirthDate());
            }

            targetProfessor.setDateModified(LocalDateTime.now());
            targetProfessor.setRevisionNumber(targetProfessor.getRevisionNumber() + 1);

            professorRepository.save(targetProfessor);
        }
    }

    public void delete(Professor professor) {
        if (StringUtils.isEmpty(professor.getProfessorId())) {
            throw new ProfTrackerAppException(ExceptionConstants.MISSING_PROFESSOR_ID);
        }

        Professor targetProfessor = professorRepository.findOneByProfessorIdAndDeleted(professor.getProfessorId(), false);
        if (targetProfessor == null) {
            throw new ProfTrackerAppException(ExceptionConstants.PROFESSOR_DOES_NOT_EXIST);
        } else {
            targetProfessor.setDeleted(true);
            targetProfessor.setDateModified(LocalDateTime.now());
            targetProfessor.setRevisionNumber(targetProfessor.getRevisionNumber() + 1);

            professorRepository.save(targetProfessor);
        }
    }

    public Professor findOneByProfessorId(String professorId) {
        if (StringUtils.isEmpty(professorId)) {
            throw new ProfTrackerAppException(ExceptionConstants.MISSING_PROFESSOR_ID);
        }

        Professor professor = professorRepository.findOneByProfessorIdAndDeleted(professorId, false);
        if (professor == null) {
            throw new ProfTrackerAppException(ExceptionConstants.PROFESSOR_DOES_NOT_EXIST);
        } else {
            return professor;
        }
    }

    public List<Professor> findAll() {
        return professorRepository.findAllByDeleted(false);
    }

    private void validateProfessor(Professor professor) {
        if (StringUtils.isEmpty(professor.getProfessorId())) {
            throw new ProfTrackerAppException(ExceptionConstants.MISSING_PROFESSOR_ID);
        }

        if (StringUtils.isEmpty(professor.getFirstName())) {
            throw new ProfTrackerAppException(ExceptionConstants.MISSING_FIRST_NAME);
        }

        if (StringUtils.isEmpty(professor.getLastName())) {
            throw new ProfTrackerAppException(ExceptionConstants.MISSING_LAST_NAME);
        }

        if (professor.getBirthDate() == null) {
            throw new ProfTrackerAppException(ExceptionConstants.MISSING_BIRTH_DATE);
        }
    }
}
