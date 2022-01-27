package pl.sggw.transportapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.sggw.transportapp.model.entity.Course;
import pl.sggw.transportapp.model.entity.Line;
import pl.sggw.transportapp.model.entity.Trip;
import pl.sggw.transportapp.model.entity.UserTrip;
import pl.sggw.transportapp.model.repository.BookedRepository;
import pl.sggw.transportapp.model.repository.CoursesRepository;
import pl.sggw.transportapp.model.repository.LinesRepository;
import pl.sggw.transportapp.model.repository.TripsRepository;
import pl.sggw.transportapp.model.repository.UsersTripsRepository;

import javax.validation.ValidationException;
import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class LineServiceImpl {

  private final LinesRepository linesRepository;

  public Page<Line> listAllLines(Pageable pageable) {
    return linesRepository.findAll(pageable);
  }
}
