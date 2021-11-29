package pl.sggw.transportapp.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.sggw.transportapp.model.entity.UserTrip;

public interface UsersTripsRepository extends JpaRepository<UserTrip, Long>, JpaSpecificationExecutor<UserTrip> {

}