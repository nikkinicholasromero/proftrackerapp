package ph.com.demo.proftrackerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ph.com.demo.proftrackerapp.controller.response.Error;
import ph.com.demo.proftrackerapp.controller.response.StandardResponse;
import ph.com.demo.proftrackerapp.domain.User;
import ph.com.demo.proftrackerapp.service.AuthenticationService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikkiromero on 08/04/2017.
 */
@RestController
@RequestMapping("/authentication")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "/login")
    public StandardResponse login(@RequestBody User user) {
        boolean isUserValid = authenticationService.isUserValid(user);

        StandardResponse standardResponse = new StandardResponse();

        if (isUserValid) {
            standardResponse.setStatus("SUCCESS");
        } else {
            standardResponse.setStatus("FAILED");

            List<Error> errors = new ArrayList<>();
            Error error = new Error();
            error.setCode("CREDENTIALS_DID_NOT_MATCH");
            error.setMessage("Your credentials did not match. ");
            errors.add(error);
            standardResponse.setErrors(errors);
        }

        return standardResponse;
    }
}
