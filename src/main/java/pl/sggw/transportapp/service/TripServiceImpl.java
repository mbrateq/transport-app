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

import java.util.List;

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
        return tripsRepository.findByCourse(courseId);
    }

    public List<Course> listCoursesByLine(long lineId) {
        return coursesRepository.findByLine(lineId);
    }

    public List<Line> listAllLines() {
        return linesRepository.findAll();
    }

    public UserTrip bookTrip(long tripId, long userId) {
//        TODO implement
        return null;
    }

    public List<UserTrip> listBookedTripsByUser(long userId) {
        return usersTripsRepository.findByUserId(userId);
    }

    public List<UserTrip> deleteBooking(long reservationId) {
        UserTrip userTrip = usersTripsRepository.findById(reservationId).get();
        long userId = userTrip.getUserId();
        bookedRepository.findByUserIdAndAndTripId(userTrip.getUserId(), userTrip.getTripId()).ifPresent(booked -> bookedRepository.delete(booked));
        usersTripsRepository.delete(userTrip);
//        TODO zmienić poziom zabookowania przejazdu
        return usersTripsRepository.findByUserId(userId);
    }
}
