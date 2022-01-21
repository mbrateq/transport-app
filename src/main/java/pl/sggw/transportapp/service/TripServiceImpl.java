package pl.sggw.transportapp.service;

import lombok.RequiredArgsConstructor;
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
  private final LinesRepository linesRepository;
  private final CoursesRepository coursesRepository;
  private final UsersTripsRepository usersTripsRepository;
  private final BookedRepository bookedRepository;

  public List<Trip> listAllTrips() {
    return tripsRepository.findAll();
  }

  public List<Trip> listAllActiveTripsByCourse(long courseId) {
    return tripsRepository.findByCourseAndStatus(courseId, "ACTIVE");
  }

  public List<Course> listCoursesByLine(long lineId) {
    return coursesRepository.findByLine(lineId);
  }

  public List<Line> listAllLines() {
    return linesRepository.findAll();
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
    if (trip.getVehicle().getCapacity() < trip.getOccupied()) {
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

  public List<UserTrip> listBookedTripsByUser(long userId) {
    return usersTripsRepository.findByUserId(userId);
  }

  public List<UserTrip> deleteBooking(long tripId, long userId) {
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
    return usersTripsRepository.findByUserId(userId);
  }
}
