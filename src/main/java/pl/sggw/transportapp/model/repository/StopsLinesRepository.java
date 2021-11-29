package pl.sggw.transportapp.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import pl.sggw.transportapp.model.entity.StopLine;

@Repository
public interface StopsLinesRepository extends JpaRepository<StopLine, Long>, JpaSpecificationExecutor<StopLine> {

}