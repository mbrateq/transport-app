package pl.sggw.transportapp.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sggw.transportapp.model.entity.Line;
import pl.sggw.transportapp.service.LineServiceImpl;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/lines")
public class LinesController extends ControllerAbstract {

  private final LineServiceImpl lineService;

  @GetMapping("/")
  public Page<Line> listAllLines(
      @RequestParam(name = "per-page", defaultValue = "20", required = false) int pageSize,
      @RequestParam(name = "page", defaultValue = "1", required = false) int page) {
    return lineService.listAllLines(preparePageRequest(page,pageSize));
  }
}
