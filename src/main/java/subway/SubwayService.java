package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class SubwayService {

    public void addStation(String name) {
        Station station = new Station(name);
        StationRepository.addStation(station);
    }

    public void addLine(String name, String[] stationNames) {
        Line line = new Line(name);
        for (String stationName : stationNames) {
            Station station = StationRepository.stations().stream()
                    .filter(s -> s.getName().equals(stationName))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 역입니다."));
            line.addStation(station);
        }
        LineRepository.addLine(line);
    }
}
