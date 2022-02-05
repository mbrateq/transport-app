package pl.sggw.transportapp.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import pl.sggw.transportapp.model.entity.Course;
import pl.sggw.transportapp.view.CourseView;

import javax.validation.constraints.NotNull;

@Tag(name = "KURSY", description = "Zarządzanie kursami")
public interface CoursesOperations {

  @Operation(summary = "Pobranie listy kursów dla danej linii.")
  Page<CourseView> listCoursesByLine(
      @NotNull @PathVariable(name = "lineId") long courseId, int pageSize, int page);

  @Operation(summary = "Pobranie listy kursów.")
  Page<CourseView> listAllCourses(int pageSize, int page);
}
