package pl.sggw.transportapp.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "trips")
public class Trip implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "trip_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tripId;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false, insertable = false)
    private Vehicle vehicle;

    @Column(name = "occupied", nullable = false)
    private Boolean occupied;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "estimated_start_time", nullable = false)
    private Date estimatedStartTime;

    @Column(name = "estimated_end_time", nullable = false)
    private Date estimatedEndTime;

}
