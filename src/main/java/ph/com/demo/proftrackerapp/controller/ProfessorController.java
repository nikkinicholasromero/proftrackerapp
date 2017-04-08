package ph.com.demo.proftrackerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ph.com.demo.proftrackerapp.controller.response.StandardResponse;
import ph.com.demo.proftrackerapp.domain.Professor;
import ph.com.demo.proftrackerapp.service.ProfessorService;

import java.util.List;

/**
 * Created by nikkiromero on 23/03/2017.
 */
@RestController
@RequestMapping("/professors")
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @RequestMapping(value = "/schedules")
    public StandardResponse<List<Professor>> findAll() {
        StandardResponse<List<Professor>> standardResponse = new StandardResponse<>();
        standardResponse.setStatus("SUCCESS");
        standardResponse.setPayload(professorService.findAll());
        return standardResponse;
    }
}
