package subway.domain;

import java.util.LinkedList;

import static subway.service.utils.Managerable.subwayException;

public class Line {
    private String name;
    private LinkedList<Station> stations = new LinkedList<>();

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

    public boolean setStations(final Station upper, final Station bottom) {
        stations.addFirst(upper);
        stations.addLast(bottom);
        return true;
    }

    public void addStation(final Station station, final int index) {
        if(index==0){
            stations.addFirst(station);
            return;
        }
        if(index==stations.size()){
            stations.addLast(station);
            return;
        }
        stations.add(index-1, station);
    }

    public boolean deleteStation(final String station) {
        if(stations.size() <= 2) subwayException.underTwoStation();
        for (int index = 0; index < stations.size(); index++) {
            Station s = stations.get(index);
            if (s.getName().equals(station)) {
                stations.remove(s);
                return true;
            }
        }
        return false;
    }

    public boolean haveStation(final String name){
        for(Station station:stations){
            if(name.equals(station.getName())) return true;
        }
        return false;
    }

    public int getSize(){
        return this.stations.size();
    }

    public Station getStation(int index){
        return this.stations.get(index);
    }
}
