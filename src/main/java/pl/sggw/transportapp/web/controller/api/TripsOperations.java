package pl.sggw.transportapp.web.controller.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import pl.sggw.transportapp.model.entity.Course;
import pl.sggw.transportapp.model.entity.Line;
import pl.sggw.transportapp.model.entity.Trip;
import pl.sggw.transportapp.model.entity.UserTrip;

import java.util.List;

@Tag(name = "TRIPS", description = "Przejazdy")
public interface TripsOperations {

  @Operation(summary = "Pobranie listy przejazdów")
  ResponseEntity<List<Trip>> listAllTrips();

  @Operation(summary = "Pobranie listy aktywnych przejazdów dla kursu")
  ResponseEntity<List<Trip>> listAllActiveTripsByCourse(long courseId);

  @Operation(summary = "Pobranie listy kursów dla danej linii")
  ResponseEntity<List<Course>> listCoursesByLine(long lineId);

  @Operation(summary = "Pobranie listy linii")
  ResponseEntity<List<Line>> listAllLines();

  @Operation(summary = "Rezerwacja przejazdu")
  ResponseEntity<UserTrip> bookTrip(long tripId, long userId);

  @Operation(summary = "Pobranie listy aktywnych rezerwacji dla użytkownika")
  ResponseEntity<List<UserTrip>> listBookedTripsByUser(long userId);

  @Operation(summary = "Odwołanie Rezerwacji")
  ResponseEntity<List<UserTrip>> deleteBooking(long bookingId);
}
