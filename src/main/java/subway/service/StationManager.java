package subway.service;

import subway.domain.Station;
import static subway.service.DataManager.stationRepo;

// 역 관련 기능하는 서비스
public class StationManager extends Managerable {
    @Override // 삽입
    public boolean isValid(final String name) {
//        해당 역이 존재하는 지 확인
//        삽입
        if(stationRepo.getStationByName(name)!=null){
            // 이미 존재하는 역이라고 전달하기
            return false; // 문자열 반환해서 상태 메시지 출력에 활용
        }
        stationRepo.addStation(new Station(name));
        return true;
    }

    public boolean isExist(final String name){
        if(stationRepo.getStationByName(name)!=null){
            // 이미 존재하는 역이라고 전달하기
            return true; // 문자열 반환해서 상태 메시지 출력에 활용
        }
        return false;
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
