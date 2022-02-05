package pl.sggw.transportapp.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sggw.transportapp.model.entity.Line;
import pl.sggw.transportapp.service.LineServiceImpl;
import pl.sggw.transportapp.service.StopServiceImpl;
import pl.sggw.transportapp.view.StopCourseView;
import pl.sggw.transportapp.view.StopLineView;

import javax.validation.constraints.NotEmpty;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/lines")
public class LinesController extends ControllerAbstract implements LinesOperations {

  private final LineServiceImpl lineService;
  private final StopServiceImpl stopService;

  @Override
  @GetMapping("/")
  public Page<Line> listAllLines(
          @RequestParam(name = "per-page", defaultValue = "20", required = false) int pageSize,
          @RequestParam(name = "page", defaultValue = "1", required = false) int page) {
    return lineService.listAllLines(preparePageRequest(page,pageSize));
  }

  @Override
  @GetMapping("/{lineId}/stops")
  public Page<StopLineView> listStopsByLine(
          @NotEmpty @PathVariable(name = "lineId") long lineId,
          @RequestParam(name = "per-page", defaultValue = "20", required = false) int pageSize,
          @RequestParam(name = "page", defaultValue = "1", required = false) int page) {
    return stopService.listStopsByLine(lineId, preparePageRequest(page, pageSize));
  }

  @Override
  @GetMapping("/{courseId}/course")
  public Page<StopCourseView> listStopsByCourse(
          @NotEmpty @PathVariable(name = "courseId") long courseId,
          @RequestParam(name = "per-page", defaultValue = "20", required = false) int pageSize,
          @RequestParam(name = "page", defaultValue = "1", required = false) int page) {
    return stopService.listStopsByCourse(courseId, preparePageRequest(page, pageSize));
  }
}
