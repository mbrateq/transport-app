package pl.sggw.transportapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.sggw.transportapp.model.entity.Line;
import pl.sggw.transportapp.model.entity.Stop;
import pl.sggw.transportapp.model.entity.StopCourse;
import pl.sggw.transportapp.model.entity.StopLine;
import pl.sggw.transportapp.model.repository.LinesRepository;
import pl.sggw.transportapp.model.repository.StopsCoursesRepository;
import pl.sggw.transportapp.model.repository.StopsLinesRepository;
import pl.sggw.transportapp.model.repository.StopsRepository;
import pl.sggw.transportapp.view.StopCourseView;
import pl.sggw.transportapp.view.StopLineView;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StopServiceImpl implements TripService {

  private final StopsLinesRepository stopsLinesRepository;
  private final StopsCoursesRepository stopsCoursesRepository;
  private final StopsRepository stopsRepository;
  private final LinesRepository linesRepository;

  public Page<Stop> listStops(Pageable pageable) {
    return stopsRepository.findAll(pageable);
  }

  public Page<StopLineView> listStopsByLine(long lineId, Pageable pageable) {
    List<StopLine> stopsLines = stopsLinesRepository.findByLineIdOrderByOrdinalAsc(lineId);
    List<StopLineView> result =
        stopsLines.stream()
            .map(
                stopLine -> {
                  final Stop stop = stopsRepository.findById(stopLine.getStopId()).get();
                  return StopLineView.toStopLineView(stop, stopLine);
                })
            .collect(Collectors.toList());
    return new PageImpl<>(result, pageable, result.size());
  }

  public Page<StopCourseView> listStopsByCourse(long courseId, Pageable pageable) {
    List<StopCourse> stopCourses =
        stopsCoursesRepository.findByCourseIdOrderByEstimatedAsc(courseId);
    List<StopCourseView> result =
        stopCourses.stream()
            .map(
                stopCourse -> {
                  final Stop stop = stopsRepository.findById(stopCourse.getStopId()).get();
                  return StopCourseView.toStopCourseView(stop, stopCourse);
                })
            .collect(Collectors.toList());
    return new PageImpl<>(result, pageable, result.size());
  }

  public Page<Line> listLinesByStop(long stopId, Pageable pageable) {
    List<StopLine> stopLines = stopsLinesRepository.findByStopId(stopId);
    List<Line> result =
        stopLines.stream()
            .map(
                stopLine -> {
                  final Line line = linesRepository.findById(stopLine.getLineId()).get();
                  return line;
                })
            .collect(Collectors.toList());
    return new PageImpl<>(result, pageable, result.size());
  }
}
