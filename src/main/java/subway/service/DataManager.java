package subway.service;

import subway.config.constants.initValues.*;
import subway.config.handler.SubwayException;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;


// TODO code 리팩토링
public class DataManager{
    private final static LineNames lines = new LineNames(); // String[]
    private final static StationNames stations = new StationNames(); // String[]

    final static LineRepository lineRepo = new LineRepository();
    final static StationRepository stationRepo = new StationRepository();

    final static StationManager stationManager = new StationManager();
    final static SectionManager sectionManager = new SectionManager();
    final static LineManager lineManager = new LineManager();

    final static SubwayException subwayException = new SubwayException();

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

    public DataManager(){
        // 초기값 삽입
        addStations();
        addLines();
    }

    public void addStations(){
        Stations[] names = Stations.values();
        for(Stations name: names){
            stationRepo.addStation(new Station(String.valueOf(name)));
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

    public void lineSet(final Line line){
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
