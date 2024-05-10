package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private List<Station> stations = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public void addStation(Station station) {
        stations.add(station);
    }

    public void removeStation(Station station) {
        stations.remove(station);
    }

    public List<Station> getStations() {
        return stations;
    }

    public void addStationAt(Station station, int index) {
        if (index >= 0 && index <= stations.size()) {
            stations.add(index, station);
        }
    }

    public boolean removeStationByName(String stationName) {
        return stations.removeIf(station -> station.getName().equals(stationName));
    }
}
