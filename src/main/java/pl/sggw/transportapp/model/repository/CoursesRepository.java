package pl.sggw.transportapp.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.sggw.transportapp.model.entity.Course;
import pl.sggw.transportapp.model.entity.Line;

@Repository
public interface CoursesRepository extends PagingAndSortingRepository<Course, Long> {

  Page<Course> findByLine(Line line, Pageable pageable);
}
