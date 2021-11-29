package pl.sggw.transportapp.model.specification;

import org.springframework.data.jpa.domain.Specification;
import pl.sggw.transportapp.model.entity.Trip;
import pl.sggw.transportapp.model.entity.Trip_;

public class TripSpecification {
    public static Specification<Trip> statusEquals(String status){
    return (root, query, cb) -> cb.equal(root.get(Trip_.STATUS), status);
    }
}
