package ph.com.demo.proftrackerapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.com.demo.proftrackerapp.domain.User;
import ph.com.demo.proftrackerapp.repository.UserRepository;
import ph.com.demo.proftrackerapp.service.AuthenticationService;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by nikkiromero on 25/03/2017.
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private UserRepository userRepository;

    public boolean isUserValid(User user) {
        User targetUser = userRepository.findOneByUserTypeAndEmail(user.getUserType(), user.getEmail());

        if (targetUser == null) {
            return false;
        }

        user.setPassword(hash(targetUser.getSalt() + user.getPassword() + targetUser.getSalt()));

        if (user.getPassword().equals(targetUser.getPassword())) {
            return true;
        } else {
            return false;
        }
    }


    private String hash(final String text) {
        try {
            final MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(text.getBytes());
            final byte byteData[] = messageDigest.digest();

            final StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                stringBuffer.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }

            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private String generateRandomSalt() {
        return new BigInteger(130, new SecureRandom()).toString(32);
    }
}
