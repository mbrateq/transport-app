package pl.sggw.transportapp.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sggw.transportapp.model.entity.Line;
import pl.sggw.transportapp.model.entity.Stop;
import pl.sggw.transportapp.model.entity.StopLine;
import pl.sggw.transportapp.service.StopServiceImpl;
import pl.sggw.transportapp.view.StopCourseView;
import pl.sggw.transportapp.view.StopLineView;

import javax.validation.constraints.NotEmpty;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/stops")
public class StopsController extends ControllerAbstract implements StopsOperations {

  private final StopServiceImpl stopService;

  @Override
  @GetMapping("/")
  public Page<Stop> listAllStops(
          @RequestParam(name = "per-page", defaultValue = "20", required = false) int pageSize,
          @RequestParam(name = "page", defaultValue = "1", required = false) int page) {
    return stopService.listStops(preparePageRequest(page, pageSize));
  }
  @Override
  @GetMapping("/{stopId}/lines")
  public Page<Line> listLinesByStop(
          @NotEmpty @PathVariable(name = "stopId") long stopId,
          @RequestParam(name = "per-page", defaultValue = "20", required = false) int pageSize,
          @RequestParam(name = "page", defaultValue = "1", required = false) int page) {
    return stopService.listLinesByStop(stopId, preparePageRequest(page, pageSize));
  }
}
