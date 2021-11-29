package pl.sggw.transportapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sggw.transportapp.model.entity.Line;
import pl.sggw.transportapp.model.entity.Trip;
import pl.sggw.transportapp.model.entity.UserTrip;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TripServiceImpl implements TripService {

    List<Trip> listAllTrips(){
//        TODO IMPLEMENT
        return null;
    }

    List<Trip> listAllActiveTripsByLine(long lineId){
//        TODO IMPLEMENT
        return null;
    }
    
    List<Line> listAllLines(){
//        TODO IMPLEMENT
        return null;
    }
    
    UserTrip bookTrip(long tripId, long userId){
//        TODO IMPLEMENT
        return null;
    }
    
    UserTrip listBookedTripsByUser(long userId){
//        TODO IMPLEMENT
        return null;
    }
    
    UserTrip deleteBooking(long tripId, long userId){
//        TODO IMPLEMENT
        return null;
    }
}
