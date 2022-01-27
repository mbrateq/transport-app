package pl.sggw.transportapp.view;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import pl.sggw.transportapp.model.entity.Stop;
import pl.sggw.transportapp.model.entity.StopCourse;
import pl.sggw.transportapp.model.entity.StopLine;

import java.sql.Time;
import java.time.LocalTime;

@RequiredArgsConstructor
@Getter
@SuperBuilder
public class StopCourseView {
  private String stopName;
  private long stopId;
  private long stopCourseId;
  private long ordinal;
  private LocalTime estimated;

  public static StopCourseView toStopCourseView(Stop stop, StopCourse stopCourse) {
    return StopCourseView.builder()
        .stopName(stop.getStopName())
        .stopId(stopCourse.getStopId())
        .estimated(stopCourse.getEstimated().toLocalTime())
        .build();
  }
}
