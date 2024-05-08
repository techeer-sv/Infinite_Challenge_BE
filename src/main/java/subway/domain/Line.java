package subway.domain;

import java.util.LinkedList;

public class Line {
    private String name;
    private LinkedList<Station> stations = new LinkedList<>();
    private Station upperStation;
    private Station bottomStation;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStations(Station upper, Station bottom){
        this.upperStation = upper;
        this.bottomStation=bottom;
        stations.add(upper);
        stations.add(bottom);
    }

    // 추가 기능 구현
}
