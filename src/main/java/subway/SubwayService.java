package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.List;

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

    public void deleteStation(String name) {
        if (LineRepository.lines().stream()
                .flatMap(line -> line.getStations().stream())
                .anyMatch(station -> station.getName().equals(name))) {
            throw new IllegalArgumentException("[ERROR] 노선에 등록된 역은 삭제할 수 없습니다.");
        }
        if (!StationRepository.deleteStation(name)) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 역입니다.");
        }
    }

    public List<Station> getStations() {
        return StationRepository.stations();
    }
}
