package pl.sggw.transportapp.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.sggw.transportapp.model.entity.Trip;

public interface TripsRepository extends JpaRepository<Trip, Long>, JpaSpecificationExecutor<Trip> {

}