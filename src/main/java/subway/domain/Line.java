package subway.domain;

import java.util.LinkedList;
import java.util.ListIterator;

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

    public void insertStation(Station node, int index){
        stations.add(index, node);
    }

    // 추가 기능 구현
    public Station getStationByName(String name){
        for(Station station : stations){
            if(station.getName().equals(name)){
                return station;
            }
        }
        return null;
    }
}
