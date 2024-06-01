package subway.domain;

import subway.global.error.ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private String name;
    private List<Station> stations = new ArrayList<>();
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

    public List<Station> getStations() {
        return Collections.unmodifiableList(stations);
    }
}
