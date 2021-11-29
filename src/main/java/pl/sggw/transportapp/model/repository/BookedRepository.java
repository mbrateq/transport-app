package pl.sggw.transportapp.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.sggw.transportapp.model.entity.Booked;

public interface BookedRepository extends JpaRepository<Booked, Long>, JpaSpecificationExecutor<Booked> {

}