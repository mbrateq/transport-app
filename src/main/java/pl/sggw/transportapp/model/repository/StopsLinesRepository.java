package pl.sggw.transportapp.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.sggw.transportapp.model.entity.StopLine;

import java.util.List;

@Repository
public interface StopsLinesRepository extends PagingAndSortingRepository<StopLine, Long> {
  List<StopLine> findByLineIdOrderByOrdinalAsc(long lineId);
  List<StopLine> findByStopId(long stopId);
}
