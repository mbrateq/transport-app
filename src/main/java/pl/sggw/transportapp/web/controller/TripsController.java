package pl.sggw.transportapp.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sggw.transportapp.model.entity.Course;
import pl.sggw.transportapp.model.entity.Line;
import pl.sggw.transportapp.model.entity.Trip;
import pl.sggw.transportapp.model.entity.UserTrip;
import pl.sggw.transportapp.service.TripService;
import pl.sggw.transportapp.service.TripServiceImpl;
import pl.sggw.transportapp.web.controller.api.TripsOperations;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class TripsController implements TripsOperations {

    private final TripServiceImpl tripService;

    @GetMapping("/trips")
    @Override
    public ResponseEntity<List<Trip>> listAllTrips() {
        return ResponseEntity.ok(tripService.listAllTrips());
    }

    @GetMapping("/trips/{courseId}")
    @Override
    public ResponseEntity<List<Trip>> listAllActiveTripsByCourse(@PathVariable long courseId) {
        return ResponseEntity.ok(tripService.listAllActiveTripsByCourse(courseId));
    }

    @GetMapping("/courses/{lineId}")
    @Override
    public ResponseEntity<List<Course>> listCoursesByLine(@PathVariable long lineId) {
        return ResponseEntity.ok(tripService.listCoursesByLine(lineId));
    }

    @GetMapping("/lines")
    @Override
    public ResponseEntity<List<Line>> listAllLines() {
        return ResponseEntity.ok(tripService.listAllLines());
    }

    @PostMapping("/trips/{tripId}/{userId}")
    @Override
    public ResponseEntity<UserTrip> bookTrip(@PathVariable long tripId, @PathVariable long userId) {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/trips/{userId}")
    @Override
    public ResponseEntity<List<UserTrip>> listBookedTripsByUser(long userId) {
        return ResponseEntity.ok(tripService.listBookedTripsByUser(userId));
    }

    @DeleteMapping("/trips/{tripId}/{userId}")
    @Override
    public ResponseEntity<List<UserTrip>> deleteBooking(long bookingId) {
        return ResponseEntity.ok(tripService.deleteBooking(bookingId));
    }
}
