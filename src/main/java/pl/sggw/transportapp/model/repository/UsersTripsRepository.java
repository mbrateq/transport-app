package pl.sggw.transportapp.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import pl.sggw.transportapp.model.entity.UserTrip;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersTripsRepository extends JpaRepository<UserTrip, Long>, JpaSpecificationExecutor<UserTrip> {

    List<UserTrip> findByUserId(long userId);

    Optional<UserTrip> findByUserIdAndTripId(long userId, long tripId);

    boolean existsByUserIdAndTripId(long userId, long tripId);
}