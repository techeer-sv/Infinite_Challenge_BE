package subway.service;

import subway.domain.Station;

import java.util.List;

public class StationManager extends Managerbale{
    @Override // 삽입
    public void register(String command) {
// if command.equals("station") 역만 삽입하는 모듈 연결
// if command.equals("line") 노선 삽입하는 모듈 연결
// if command.equals("Section") 구간 삽입하는 모듈 연결
    }

    public void insertStation(String node){
        // 이미 해당 역이 존재하는지 아닌지 확인하는 코드 추가 (util 로 만들기)
        // 존재하지 않는다
        Station station = new Station(node);
        stationRepo.addStation(station);
    }

    @Override
    public void delete(String name) {
        stationRepo.deleteStation(name);
    }

    @Override
    public void read() {
//        역 조회
    }

    public List<Station> readStation(){
        return stationRepo.stations();
    }
}
