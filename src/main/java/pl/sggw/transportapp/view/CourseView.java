package pl.sggw.transportapp.view;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@RequiredArgsConstructor
@Getter
@SuperBuilder
public class CourseView {
  private long courseId;
  private long lineId;
  private String lineName;
  private List<StopCourseView> stopCourses;
}
