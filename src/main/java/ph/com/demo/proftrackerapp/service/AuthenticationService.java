package ph.com.demo.proftrackerapp.service;

import ph.com.demo.proftrackerapp.domain.User;

/**
 * Created by nikkiromero on 23/03/2017.
 */
public interface AuthenticationService {
    boolean isUserValid(User user);
}
