package pl.sggw.transportapp.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.sggw.transportapp.model.entity.UserTrip;

import java.util.Optional;

@Repository
public interface UsersTripsRepository extends PagingAndSortingRepository<UserTrip, Long> {

  Page<UserTrip> findByUserId(long userId, Pageable pageable);

  Optional<UserTrip> findByUserIdAndTripId(long userId, long tripId);
}
