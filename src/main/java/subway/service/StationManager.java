package subway.service;

import subway.config.handler.SubwayException;
import subway.domain.Station;
import static subway.service.InitManager.stationRepo;

// 역 관련 기능하는 서비스
public class StationManager implements Managerable {
    @Override // 삽입
    public boolean isEmpty(final String name) {
        if(stationRepo.getStationByName(name)!=null){
            // TODO: 이미 존재하는 역
            throw new SubwayException();
        }
        stationRepo.addStation(new Station(name));
        return true;
    }
    @Override
    public boolean delete(final String name) {
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

    public Station getByName(final String name){
        try{
            isEmpty(name);
        }catch (SubwayException e){
            e.alreadyCreatedStation();
        }
        return stationRepo.getStationByName(name);
    }
}
