package pl.sggw.transportapp.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import pl.sggw.transportapp.model.entity.Trip;
import pl.sggw.transportapp.model.entity.UserTrip;

@Tag(name = "PRZEJAZDY", description = "Zarządzanie przejazdami")
public interface TripsOperations {

  @Operation(summary = "Pobranie listy przejazdów")
  Page<Trip> listAllTrips(int pageSize, int page);

  @Operation(summary = "Pobranie listy aktywnych przejazdów dla kursu.")
  Page<Trip> listAllActiveTripsByCourse(long courseId, int pageSize, int page);

  @Operation(summary = "Pobranie listy przejazdów zarezerwowanych przez użytkownika")
  Page<UserTrip> listBookedTripsByUser(long userId, int pageSize, int page);

  @Operation(summary = "Rezerwacja przejazdu")
  ResponseEntity<UserTrip> bookTrip(long tripId, long userId);

  @Operation(summary = "Usunięcie rezerwacji")
  boolean deleteBooking(long tripId, long userId);
}
