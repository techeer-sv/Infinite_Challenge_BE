package subway.service;

import subway.config.handler.InputException;
import subway.config.handler.SubwayException;
import subway.domain.Line;
import subway.domain.Station;

import java.util.List;

import static subway.service.InitSubwayValues.stationRepo;

// 역 관련 기능하는 서비스
public class StationManager implements Managerable {
    InputException inputException= new InputException();
    @Override // 삽입
    public boolean isEmpty(final String name) {
        if(stationRepo.getStationByName(name)!=null){
            inputException.alreadyCreatedStation();
            return false;
        }
        stationRepo.addStation(new Station(name));
        return true;
    }
    @Override
    public boolean delete(final String name) {
        Station station = stationRepo.getStationByName(name);
        List<Line> lines = station.getLine();

        for(Line line : lines){
            line.deleteStation(name);
        }
        return stationRepo.deleteStation(name);
    }

    @Override
    public StringBuilder read() {
        StringBuilder sb = new StringBuilder();
        for(Station station : stationRepo.stations()){
            sb.append("[INFO] " + station.getName()+"\n");
        }
        return sb;
    }

    public Station getByStationName(final String name){
        Station station =stationRepo.getStationByName(name);
        if(station == null){
            subwayException.noStation();
        }
        return station;
    }
}
