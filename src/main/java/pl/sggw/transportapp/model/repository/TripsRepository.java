package pl.sggw.transportapp.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.sggw.transportapp.model.entity.Trip;

@Repository
public interface TripsRepository extends PagingAndSortingRepository<Trip, Long> {

  Page<Trip> findByCourseAndStatus(long courseId, String status, Pageable pageable);
}
