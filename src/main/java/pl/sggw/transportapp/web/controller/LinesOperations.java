package pl.sggw.transportapp.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import pl.sggw.transportapp.model.entity.Line;
import pl.sggw.transportapp.view.StopCourseView;
import pl.sggw.transportapp.view.StopLineView;

@Tag(name = "LINIE", description = "Zarządzanie liniami")
public interface LinesOperations {

  @Operation(summary = "Pobranie listy linii")
  Page<Line> listAllLines(int pageSize, int page);

  @Operation(summary = "Pobranie listy przystanków na danej linii")
  Page<StopLineView> listStopsByLine(long lineId, int pageSize, int page);

  @Operation(summary = "Pobranie listy przystanków z danego kursu")
  Page<StopCourseView> listStopsByCourse(long courseId, int pageSize, int page);
}
