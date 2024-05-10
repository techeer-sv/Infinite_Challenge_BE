package subway.service;

import subway.config.constants.initValues.*;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class DataManager{
    private final static LineNames lines = new LineNames(); // String[]
    private final static StationNames stations = new StationNames(); // String[]

    final static LineRepository lineRepo = new LineRepository();
    final static StationRepository stationRepo = new StationRepository();

    public DataManager(){
        // 초기값 삽입
//        2. 모든 노선을 입력한다.
//        3. 모든 구간을 입력한다.
        addStations();//        1. 모든 역들을 입력한다.
        addLines();
    }

    public void addStations(){
        String[] names = stations.getNames();
        for(String station: names){
            stationRepo.addStation(new Station(station));
        }
    }

    public void addLines(){
        String[] names = lines.getNames();
        for(String line: names){
            Line node = new Line(line);
            lineSet(node);
            lineRepo.addLine(node);
        }
    }

    public void lineSet(Line line){
        if(line.getName().equals("2호선")){
            line.setStations(stationRepo.getStationByName("교대역"), stationRepo.getStationByName("역삼역"));
            line.addStation(stationRepo.getStationByName("강남역"), 1);
            return;
        }
        if(line.getName().equals("3호선")){
            line.setStations(stationRepo.getStationByName("교대역"), stationRepo.getStationByName("매봉역"));
            line.addStation(stationRepo.getStationByName("양재역"), 1);
            line.addStation(stationRepo.getStationByName("남부터미널역"), 1);
            return;
        }
        if(line.getName().equals("수인분당선")){
            line.setStations(stationRepo.getStationByName("강남역"), stationRepo.getStationByName("양재시민의숲역"));
            line.addStation(stationRepo.getStationByName("양재역"), 1);
        }
    }
}
