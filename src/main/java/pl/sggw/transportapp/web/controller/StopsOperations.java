package pl.sggw.transportapp.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import pl.sggw.transportapp.model.entity.Line;
import pl.sggw.transportapp.model.entity.Stop;

@Tag(name = "PRZYSTANKI", description = "Zarządzanie przystankami przejazdami")
public interface StopsOperations {

  @Operation(summary = "Pobranie listy przystanków")
  Page<Stop> listAllStops(int pageSize, int page);

  @Operation(summary = "Pobranie listy linii zatrzymujących się na danym przystanku")
  Page<Line> listLinesByStop(long stopId, int pageSize, int page);
}
