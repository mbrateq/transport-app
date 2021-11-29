package pl.sggw.transportapp.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.sggw.transportapp.model.entity.StopLine;

public interface StopsLinesRepository extends JpaRepository<StopLine, Long>, JpaSpecificationExecutor<StopLine> {

}