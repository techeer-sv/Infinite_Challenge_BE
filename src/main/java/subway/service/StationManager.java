package subway.service;

import subway.config.handler.InputException;
import subway.domain.Line;
import subway.domain.Station;
import subway.service.utils.Managerable;
import subway.service.utils.Verify;

import java.util.List;

import static subway.service.InitSubwayValues.stationRepo;

// 역 관련 기능하는 서비스
public class StationManager extends Verify implements Managerable {

    public void register(String name){
        stationRepo.addStation(new Station(name));
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
