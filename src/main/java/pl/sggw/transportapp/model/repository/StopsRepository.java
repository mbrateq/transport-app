package pl.sggw.transportapp.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.sggw.transportapp.model.entity.Stop;

import java.util.Collection;
import java.util.List;

@Repository
public interface StopsRepository extends PagingAndSortingRepository<Stop, Long> {
  List<Stop> findByStopIdIn(Collection<Long> stopList);
}
