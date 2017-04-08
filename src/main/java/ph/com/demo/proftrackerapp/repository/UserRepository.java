package ph.com.demo.proftrackerapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ph.com.demo.proftrackerapp.domain.User;

/**
 * Created by nikkiromero on 23/03/2017.
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findOneByUserTypeAndEmail(String userType, String email);
}
