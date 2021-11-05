package lt.vu.laboratorinisdarbas3.repository;

import lt.vu.laboratorinisdarbas3.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
