package pl.sggw.transportapp.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "booked")
public class Booked implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "booked_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookedId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "vehicle_id")
    private Long vehicleId;

    @Column(name = "start_time", nullable = false)
    private Date startTime;

    @Column(name = "end_time", nullable = false)
    private Date endTime;

}
