package pl.sggw.transportapp.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.sggw.transportapp.model.entity.StopCourse;
import pl.sggw.transportapp.model.entity.StopLine;

import java.util.List;
import java.util.Optional;

@Repository
public interface StopsCoursesRepository extends PagingAndSortingRepository<StopCourse, Long> {
    List<StopCourse> findByCourseIdOrderByEstimatedAsc(long courseId);
    Optional<StopCourse> findByCourseIdAndStopId(long courseId, long stopId);
}