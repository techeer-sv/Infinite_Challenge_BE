package subway.domain;

import subway.global.error.ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final String name;
    private final List<Station> stations = new ArrayList<>();
    private String upStation;
    private String downStation;

    public Line(String name) {
        this.name = name;
    }

    public Line(String name, Station upStation, Station downStation) {
        if (name == null || name.length() < 2) {
            throw new IllegalArgumentException(ErrorMessage.LINE_TOO_SHORT);
        }
        this.name = name;
        this.upStation = String.valueOf(upStation);
        this.downStation = String.valueOf(downStation);
        stations.add(upStation);
        stations.add(downStation);
    }

    public String getName() {
        return name;
    }

    public void addStation(Station station) {
        stations.add(station);
    }

    public void addSection(Station station, Station upStation, Station downStation) {
        int upStationIndex = stations.indexOf(upStation);
        int downStationIndex = stations.indexOf(downStation);
        if (upStationIndex == -1 || downStationIndex == -1 || downStationIndex - upStationIndex != 1) {
            throw new IllegalArgumentException(ErrorMessage.SECTION_NOT_FOUND);
        }
        stations.add(downStationIndex, station);
    }

    public void removeStation(Station station) {
        if (stations.size() <= 2) {
            throw new IllegalArgumentException(ErrorMessage.TOO_FEW_STATIONS);
        }
        if (!stations.contains(station)) {
            throw new IllegalArgumentException(ErrorMessage.STATION_NOT_FOUND);
        }
        stations.remove(station);

        if (stations.get(0).equals(station)) {
            upStation = String.valueOf(stations.get(0));
        }
        if (stations.get(stations.size() - 1).equals(station)) {
            downStation = String.valueOf(stations.get(stations.size() - 1));
        }
    }

    public List<Station> getStations() {
        return Collections.unmodifiableList(stations);
    }

    public List<Station> getAllStations() {
        return Collections.unmodifiableList(new ArrayList<>(stations));
    }
}
