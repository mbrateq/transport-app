package pl.sggw.transportapp.model.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Data
@Entity
@Table(name = "lines")
public class
Line implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "line_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lineId;

    @Column(name = "line_name", nullable = false)
    private String lineName;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinTable(
            name = "STOPS_LINES",
            joinColumns = @JoinColumn(name = "LINE_ID"),
            inverseJoinColumns = @JoinColumn(name = "STOP_ID"))
    private List<Stop> stops = new LinkedList<>();

}
