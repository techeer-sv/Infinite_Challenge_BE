package subway.service;

import subway.config.constants.initValues.*;
import subway.config.handler.SubwayException;
import subway.domain.Line;
import subway.domain.Station;

import java.util.List;


public class InitManager implements Constants{

    public LineManager getLineManager(){
        return lineManager;
    }

    public static StationManager getStationManager() {
        return stationManager;
    }

    public static SectionManager getSectionManager(){
        return sectionManager;
    }
    public static SubwayException getSubwayException(){return subwayException;}

    public InitManager(){
        // 초기값 삽입
        addStations();
        addLines();
    }

    public void addStations(){
        StationName[] names = StationName.values();
        for(StationName name: names){
            String station = name.toString();
            stationRepo.addStation(new Station(station));
        }
    }

    public void addLines(){
        Lines[] lines = Lines.values();
        for(Lines line : lines){
            Line node = initLine(line);
            lineRepo.addLine(node);
        }
    }

    public Line initLine(final Lines line){
        Line node = new Line(line.getName());
        List<String> values = line.getValues();

        for(int i =0 ;i < values.size();i++){
            String station = values.get(i);
            node = addStation(node, station, i);
        }

        return node;
    }

    public Line addStation(Line line , final String value, final int index ){
        Station station = stationRepo.getStationByName(value);
        line.addStation(station, index);
        return line;
    }
}
