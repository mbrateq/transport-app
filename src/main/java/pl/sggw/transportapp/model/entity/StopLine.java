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
@Table(name = "stops_lines")
public class StopLine implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "stops_lines_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stopsLinesId;

    @Column(name = "line_id", nullable = false)
    private Long lineId;

    @Column(name = "stop_id", nullable = false)
    private Long stopId;

    @Column(name = "ordinal", nullable = false)
    private Long ordinal;

}
