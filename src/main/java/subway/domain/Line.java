package subway.domain;

import java.util.LinkedList;

public class Line {
    private String name;
    private LinkedList<Station> stations = new LinkedList<>();
    private Station upperStation;
    private Station bottomStation;

    public Line(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public StringBuilder stationList(){
        StringBuilder sb = new StringBuilder();
        for(Station station:stations){
            sb.append("[INFO] "+station.getName()).append("\n");
        }
        return sb;
    }

    public void setStations(final Station upper, final Station bottom) {
        this.upperStation = upper;
        this.bottomStation = bottom;
        stations.addFirst(upper);
        stations.addLast(bottom);
    }

    public void addStation(final Station station, final int index) {
        if(index==stations.size()){
            bottomStation = station;
            return;
        }
        if(index==0){
            upperStation=station;
            return;
        }
        stations.add(index, station);
    }

    public boolean deleteStation(final String station) {
        for (int index = 0; index < stations.size(); index++) {
            Station s = stations.get(index);
            if (s.getName().equals(station)) {
                stations.remove(index);
                return true;
            }
        }
        return false;
    }

    public Station getUpperStation(){
        return this.upperStation;
    }
    public Station getBottomStation(){
        return this.bottomStation;
    }
}
