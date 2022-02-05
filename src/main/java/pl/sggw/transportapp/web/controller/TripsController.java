package pl.sggw.transportapp.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sggw.transportapp.model.entity.Trip;
import pl.sggw.transportapp.model.entity.UserTrip;
import pl.sggw.transportapp.service.TripServiceImpl;

import javax.validation.constraints.NotEmpty;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/trips")
public class TripsController extends ControllerAbstract implements TripsOperations {

  private final TripServiceImpl tripService;

  @Override
  @GetMapping("/")
  public Page<Trip> listAllTrips(
          @RequestParam(name = "per-page", defaultValue = "20", required = false) int pageSize,
          @RequestParam(name = "page", defaultValue = "1", required = false) int page) {
    return tripService.listAllTrips(preparePageRequest(page, pageSize));
  }

  @Override
  @GetMapping("/{courseId}")
  public Page<Trip> listAllActiveTripsByCourse(
          @NotEmpty @PathVariable(name = "courseId") long courseId,
          @RequestParam(name = "per-page", defaultValue = "20", required = false) int pageSize,
          @RequestParam(name = "page", defaultValue = "1", required = false) int page) {
    return tripService.listAllActiveTripsByCourse(courseId, preparePageRequest(page, pageSize));
  }

  @Override
  @GetMapping("/{userId}/booked")
  public Page<UserTrip> listBookedTripsByUser(
          @NotEmpty @PathVariable(name = "userId") long userId,
          @RequestParam(name = "per-page", defaultValue = "20", required = false) int pageSize,
          @RequestParam(name = "page", defaultValue = "1", required = false) int page) {
    return tripService.listBookedTripsByUser(userId, preparePageRequest(page, pageSize));
  }

  @Override
  @PostMapping("/{tripId}/{userId}")
  public ResponseEntity<UserTrip> bookTrip(
          @NotEmpty @PathVariable(name = "tripId") long tripId,
          @NotEmpty @PathVariable(name = "userId") long userId) {
    return ResponseEntity.ok(tripService.bookTrip(tripId, userId));
  }

  @Override
  @DeleteMapping("/{tripId}/{userId}")
  public boolean deleteBooking(
          @NotEmpty @PathVariable(name = "tripId") long tripId,
          @NotEmpty @PathVariable(name = "userId") long userId) {
    return tripService.deleteBooking(tripId, userId);
  }
}
