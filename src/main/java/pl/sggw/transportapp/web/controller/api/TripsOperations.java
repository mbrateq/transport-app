package pl.sggw.transportapp.web.controller.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import pl.sggw.transportapp.model.entity.Line;
import pl.sggw.transportapp.model.entity.Trip;
import pl.sggw.transportapp.model.entity.UserTrip;

import java.util.List;

@Tag(name = "TRIPS", description = "Przejazdy")
public interface TripsOperations {

  @Operation(summary = "Pobranie listy przejazdów")
  ResponseEntity<List<Trip>> listAllTrips();

  @Operation(summary = "Pobranie listy aktywnych przejazdów dla danej linii")
  ResponseEntity<List<Trip>> listAllActiveTripsByLine(long lineId);

  @Operation(summary = "Pobranie listy linii")
  ResponseEntity<List<Line>> listAllLines();

  @Operation(summary = "Rezerwacja przejazdu")
  ResponseEntity<UserTrip> bookTrip(long tripId, long userId);

  @Operation(summary = "Pobranie listy aktywnych rezerwacji dla użytkownika")
  ResponseEntity<UserTrip> listBookedTripsByUser(long userId);

  @Operation(summary = "Odwołanie Rezerwacji")
  ResponseEntity<UserTrip> deleteBooking(long tripId, long userId);
}
