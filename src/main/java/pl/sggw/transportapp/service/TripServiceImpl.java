package pl.sggw.transportapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.sggw.transportapp.model.entity.Course;
import pl.sggw.transportapp.model.entity.Line;
import pl.sggw.transportapp.model.entity.Trip;
import pl.sggw.transportapp.model.entity.UserTrip;
import pl.sggw.transportapp.model.repository.BookedRepository;
import pl.sggw.transportapp.model.repository.CoursesRepository;
import pl.sggw.transportapp.model.repository.LinesRepository;
import pl.sggw.transportapp.model.repository.TripsRepository;
import pl.sggw.transportapp.model.repository.UsersTripsRepository;

import javax.validation.ValidationException;
import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class TripServiceImpl implements TripService {

  private final TripsRepository tripsRepository;
  private final UsersTripsRepository usersTripsRepository;
  private final CoursesRepository coursesRepository;

  public Page<Trip> listAllTrips(Pageable pageable) {
    return tripsRepository.findAll(pageable);
  }

  public Page<Trip> listAllActiveTripsByCourse(long courseId, Pageable pageable) {
    final Course course = coursesRepository.findById(courseId).get();
    return tripsRepository.findByCourseAndStatus(course, "ACTIVE", pageable);
  }

  public UserTrip bookTrip(long tripId, long userId) {
    usersTripsRepository
        .findByUserIdAndTripId(userId, tripId)
        .ifPresent(
            userTrip -> {
              throw new ValidationException(
                  format("Trip %s is already booked by user %s.", tripId, userId));
            });
    final Trip trip =
        tripsRepository
            .findById(tripId)
            .orElseThrow(() -> new ValidationException(format("Trip %s does not exist.", tripId)));
    if (trip.getVehicle().getCapacity() > trip.getOccupied()) {
      long occupied = trip.getOccupied();
      trip.setOccupied(occupied++);
      tripsRepository.save(trip);
      UserTrip userTrip = new UserTrip();
      userTrip.setTripId(tripId);
      userTrip.setUserId(userId);
      return usersTripsRepository.save(userTrip);
    } else {
      throw new ValidationException(
          format("Trip %s is fully booked, reservation impossible!", tripId));
    }
  }

  public Page<UserTrip> listBookedTripsByUser(long userId, Pageable pageable) {
    return usersTripsRepository.findByUserId(userId, pageable);
  }

  public boolean deleteBooking(long tripId, long userId) {
    UserTrip userTrip =
        usersTripsRepository
            .findByUserIdAndTripId(userId, tripId)
            .orElseThrow(
                () ->
                    new ValidationException(
                        format("Booking for trip %s and user %s not found!", tripId, userId)));
    Trip trip =
        tripsRepository
            .findById(tripId)
            .orElseThrow(() -> new ValidationException(format("Trip %s does not exist.", tripId)));
    long booked = trip.getOccupied();
    trip.setOccupied(booked--);
    tripsRepository.save(trip);
    usersTripsRepository.delete(userTrip);
    return true;
  }
}
