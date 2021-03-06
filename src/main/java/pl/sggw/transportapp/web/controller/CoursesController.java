package pl.sggw.transportapp.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sggw.transportapp.model.entity.Course;
import pl.sggw.transportapp.service.CourseServiceImpl;
import pl.sggw.transportapp.view.CourseView;

import javax.validation.constraints.NotNull;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/courses")
public class CoursesController extends ControllerAbstract implements CoursesOperations {

  private final CourseServiceImpl courseService;

  @GetMapping("/{lineId}")
  public Page<CourseView> listCoursesByLine(
          @NotNull @PathVariable(name = "lineId") long courseId,
      @RequestParam(name = "per-page", defaultValue = "20", required = false) int pageSize,
      @RequestParam(name = "page", defaultValue = "1", required = false) int page) {
    return courseService.listCoursesByLine(1, preparePageRequest(page, pageSize));
  }

  @Override
  @GetMapping("/")
  public Page<CourseView> listAllCourses(
      @RequestParam(name = "per-page", defaultValue = "20", required = false) int pageSize,
      @RequestParam(name = "page", defaultValue = "1", required = false) int page) {
    return courseService.listAllCourses(preparePageRequest(page, pageSize));
  }
}
