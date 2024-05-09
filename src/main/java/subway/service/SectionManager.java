package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class SectionManager extends Managerbale{
    static LineRepository lineRepo = new LineRepository();
    static StationRepository stationRepo = new StationRepository();

    @Override
    public boolean register(String name) {
        return true;
    }

    public void insertSection(String name, String sName,int index){
        // 이미 해당 역이 등록되어 있는지 확인
        // 등록되지 않았으면
        Line line = lineRepo.getLineByName(name);
        if(line == null){
            System.out.println(" 존재하지 않는 노선입니다.");
        }

        Station station = stationRepo.getStationByName(sName);
        if(station == null){
            System.out.println(" 존재하지 않는 역입니다.");
        }
        lineRepo.addLine(line, station, index);


    }

    @Override
    public boolean delete(String name) {
        return true;
    }

    @Override
    public StringBuilder read() {
        StringBuilder sb = new StringBuilder();

        sb.append("");
        return sb;
    }

    @Override
    public void goBack() {

    }
}
