package pl.sggw.transportapp.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import pl.sggw.transportapp.model.entity.Line;

@Repository
public interface LinesRepository extends JpaRepository<Line, Long>, JpaSpecificationExecutor<Line> {

}