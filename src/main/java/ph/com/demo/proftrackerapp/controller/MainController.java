package ph.com.demo.proftrackerapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nikkiromero on 22/03/2017.
 */
@RestController
public class MainController {
    @RequestMapping(value = {"", "/"})
    public String index() {
        return "The server is up and running. ";
    }
}
