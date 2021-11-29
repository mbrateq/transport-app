package pl.sggw.transportapp.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "users_trips")
public class UserTrip implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "user_trips_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userTripsId;

    @Column(name = "trip_id", nullable = false)
    private Long tripId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

}
