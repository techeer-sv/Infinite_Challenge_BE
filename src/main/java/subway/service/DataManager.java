//package subway.service;
//
//import subway.domain.Line;
//import subway.domain.LineRepository;
//import subway.domain.Station;
//import subway.domain.StationRepository;
//
//import java.util.List;
//
//public class DataManager extends Managerbale{
//    public DataManager(){
//        // 초기값 삽입
//    }
//    @Override // 삽입
//    public boolean register(String command) {
//// if command.equals("station") 역만 삽입하는 모듈 연결
//// if command.equals("line") 노선 삽입하는 모듈 연결
//// if command.equals("Section") 구간 삽입하는 모듈 연결
//        return true;
//    }
//
//    public void insertStation(String node){
//        // 이미 해당 역이 존재하는지 아닌지 확인하는 코드 추가 (util 로 만들기)
//        Station station = new Station(node);
//        stationRepo.addStation(station);
//    }
//
//    public void insertLine(String upperStation, String bottomStation, String name){
//        List<Station> stations = stationRepo.stations();
//        // 이미 해당 역이 존재하는지 아닌지 확인하는 코드 추가
//        Station upper = new Station(upperStation);
//        Station bottom = new Station(bottomStation);
//        stationRepo.addStation(upper);
//        stationRepo.addStation(bottom);
//        Line created = new Line(name);
//        lineRepo.addLine(created);
//    }
//
//    public void insertSection(){
//
//    }
//
//    @Override // 삭제
//    public boolean delete(String name) {
//        return true;
//    }
//
//    @Override // 조회
//    public StringBuilder read() {
//        StringBuilder sb = new StringBuilder();
//
//        sb.append("");
//        return sb;
//    }
//}
