package subway.service;

import subway.domain.Station;
import static subway.service.InitManager.stationRepo;

// 역 관련 기능하는 서비스
public class StationManager implements Managerable {
    @Override // 삽입
    public boolean isValid(final String name) {
        if(stationRepo.getStationByName(name)!=null){
            // 이미 존재하는 역

            return false;
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
//        역 조회
        StringBuilder sb = new StringBuilder();
        for(Station station : stationRepo.stations()){
            sb.append("[INFO] " + station.getName()+"\n");
        }
        return sb;
    }

    public Station getByName(final String name){
        isValid(name);
        return stationRepo.getStationByName(name);
    }
}
