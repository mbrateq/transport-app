package pl.sggw.transportapp.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.sggw.transportapp.model.entity.Line;

public interface LinesRepository extends JpaRepository<Line, Long>, JpaSpecificationExecutor<Line> {

}