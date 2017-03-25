package ph.com.demo.proftrackerapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ph.com.demo.proftrackerapp.domain.Professor;

import java.util.List;

/**
 * Created by nikkiromero on 23/03/2017.
 */
@Repository
public interface ProfessorRepository extends MongoRepository<Professor, String> {
    Professor findOneByProfessorIdAndDeleted(String professorId, boolean deleted);
    List<Professor> findAllByDeleted(boolean deleted);
}
