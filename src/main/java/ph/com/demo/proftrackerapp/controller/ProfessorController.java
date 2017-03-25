package ph.com.demo.proftrackerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ph.com.demo.proftrackerapp.domain.Professor;
import ph.com.demo.proftrackerapp.service.ProfessorService;

import java.util.List;

/**
 * Created by nikkiromero on 23/03/2017.
 */
@RestController
@RequestMapping("/professor")
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody Professor professor) {
        professorService.create(professor);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update(@RequestBody Professor professor) {
        professorService.update(professor);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@RequestBody Professor professor) {
        professorService.delete(professor);
    }

    @RequestMapping(value = "/{professorId}", method = RequestMethod.GET)
    public Professor findOneByProfessorId(@PathVariable("professorId") String professorId) {
        return professorService.findOneByProfessorId(professorId);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Professor> findAll() {
        return professorService.findAll();
    }
}
