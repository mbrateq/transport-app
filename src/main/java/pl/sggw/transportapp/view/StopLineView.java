package pl.sggw.transportapp.view;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import pl.sggw.transportapp.model.entity.Stop;
import pl.sggw.transportapp.model.entity.StopLine;

@RequiredArgsConstructor
@Getter
@SuperBuilder
public class StopLineView {
  private String stopName;
  private long stopId;
  private long stopLineId;
  private long ordinal;

  public static StopLineView toStopLineView(Stop stop, StopLine stopLine) {
    return StopLineView.builder()
        .stopName(stop.getStopName())
        .stopId(stopLine.getStopId())
        .stopLineId(stopLine.getLineId())
        .ordinal(stopLine.getOrdinal())
        .build();
  }
}
