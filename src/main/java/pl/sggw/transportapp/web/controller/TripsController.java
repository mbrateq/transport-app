package pl.sggw.transportapp.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sggw.transportapp.model.entity.Line;
import pl.sggw.transportapp.model.entity.Trip;
import pl.sggw.transportapp.model.entity.UserTrip;
import pl.sggw.transportapp.web.controller.api.TripsOperations;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class TripsController implements TripsOperations {



    @GetMapping("/trips")
    @Override
    public ResponseEntity<List<Trip>> listAllTrips() {
        //        TODO implement
        return null;
    }

    @GetMapping("/trips/{lineId}")
    @Override
    public ResponseEntity<List<Trip>> listAllActiveTripsByLine(@PathVariable long lineId) {
        //        TODO implement
        return null;
    }

    @GetMapping("/lines")
    @Override
    public ResponseEntity<List<Line>> listAllLines() {
        //        TODO implement
        return null;
    }

    @PostMapping("/trips/{tripId}/{userId}")
    @Override
    public ResponseEntity<UserTrip> bookTrip(@PathVariable long tripId, @PathVariable long userId) {
        //        TODO implement
        return null;
    }

    @GetMapping("/trips/{userId}")
    @Override
    public ResponseEntity<UserTrip> listBookedTripsByUser(long userId) {
        //        TODO implement
        return null;
    }

    @DeleteMapping("/trips/{tripId}/{userId}")
    @Override
    public ResponseEntity<UserTrip> deleteBooking(long tripId, long userId) {
        //        TODO implement
        return null;
    }
}
