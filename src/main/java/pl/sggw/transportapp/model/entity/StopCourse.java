package pl.sggw.transportapp.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Time;

@Data
@Entity
@Table(name = "stops_courses")
public class StopCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stops_courses_id", nullable = false)
    private Long stopsCoursesId;

    @Column(name = "course_id", nullable = false)
    private Long courseId;

    @Column(name = "stop_id", nullable = false)
    private Long stopId;

    @Column(name = "estimated", nullable = false)
    private Time estimated;

}
