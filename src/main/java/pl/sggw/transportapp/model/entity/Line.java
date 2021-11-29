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
@Table(name = "lines")
public class Line implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "line_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lineId;

    @Column(name = "line_name", nullable = false)
    private String lineName;

}
