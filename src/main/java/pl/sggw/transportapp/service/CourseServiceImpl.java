package pl.sggw.transportapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.sggw.transportapp.model.entity.Course;
import pl.sggw.transportapp.model.entity.Line;
import pl.sggw.transportapp.model.entity.Stop;
import pl.sggw.transportapp.model.entity.StopCourse;
import pl.sggw.transportapp.model.repository.CoursesRepository;
import pl.sggw.transportapp.model.repository.LinesRepository;
import pl.sggw.transportapp.model.repository.StopsCoursesRepository;
import pl.sggw.transportapp.model.repository.StopsRepository;
import pl.sggw.transportapp.view.CourseView;
import pl.sggw.transportapp.view.StopCourseView;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements TripService {

  private final CoursesRepository coursesRepository;
  private final LinesRepository linesRepository;
  private final StopsCoursesRepository stopsCoursesRepository;
  private final StopsRepository stopsRepository;

  public Page<CourseView> listCoursesByLine(long lineId, Pageable pageable) {
        final Line line = linesRepository.getById(lineId);
        final List<CourseView> result = coursesRepository.findByLine(line, pageable).stream().map(this::getCourseView).collect(Collectors.toList());
       return new PageImpl<>(result,pageable,result.size());
  }

  public Page<CourseView> listAllCourses(Pageable pageable) {
    final List<CourseView> result  = coursesRepository.findAll(pageable).stream().map(this::getCourseView).collect(Collectors.toList());
    return new PageImpl<>(result,pageable,result.size());
  }

  public List<StopCourseView> getStopCoursesViews(List<Stop> stopCourses, long courseId) {
    return stopCourses.stream()
            .map(
                    stop -> {
                      final StopCourse stopCourse = stopsCoursesRepository.findByCourseIdAndStopId(courseId,stop.getStopId()).get();
                      final Stop s = stopsRepository.findById(stopCourse.getStopId()).get();
                      return StopCourseView.toStopCourseView(s, stopCourse);
                    })
            .collect(Collectors.toList());
  }
  public CourseView getCourseView(Course course) {
    return CourseView.builder()
        .courseId(course.getCourseId())
        .lineId(course.getLine().getLineId())
        .lineName(course.getLine().getLineName())
            .stopCourses(getStopCoursesViews(course.getLine().getStops(),course.getCourseId()))
        .build();
  }
}
