package subway.domain;

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
            throw new IllegalArgumentException("[ERROR] 노선 이름은 2글자 이상이어야 합니다.");
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

    public List<Station> getStations() {
        return Collections.unmodifiableList(stations);
    }
}
