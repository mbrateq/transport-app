package pl.sggw.transportapp.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import pl.sggw.transportapp.model.entity.Booked;

import java.util.Optional;

@Repository
public interface BookedRepository extends JpaRepository<Booked, Long>, JpaSpecificationExecutor<Booked> {
    Optional<Booked> findByUserIdAndAndTripId(long userId, long tripId);
}