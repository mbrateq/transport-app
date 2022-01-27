package pl.sggw.transportapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.sggw.transportapp.model.entity.Course;
import pl.sggw.transportapp.model.repository.CoursesRepository;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements TripService {

  private final CoursesRepository coursesRepository;

  public Page<Course> listCoursesByLine(long lineId, Pageable pageable) {
    return coursesRepository.findByLine(lineId, pageable);
  }

  public Page<Course> listAllCourses(Pageable pageable) {
    return coursesRepository.findAll(pageable);
  }
}
