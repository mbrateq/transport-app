package pl.sggw.transportapp.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.sggw.transportapp.model.entity.User;

public interface UsersRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

}