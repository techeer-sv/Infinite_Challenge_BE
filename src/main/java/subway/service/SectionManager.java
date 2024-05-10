package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import static subway.service.DataManager.lineRepo;
import static subway.service.DataManager.stationRepo;

public class SectionManager extends Managerable {
    private Line line;

    @Override
    public boolean register(String name) {
        line = lineRepo.getLineByName(name);
        if(line == null){
            System.out.println(" 존재하지 않는 노선입니다.");
        }
        return true;
    }

    public void insertSection(String sName,int index){
        Station station = stationRepo.getStationByName(sName);
        if(station == null){
            System.out.println(" 존재하지 않는 역입니다.");
        }
        lineRepo.addLine(line, station, index);
    }

    @Override
    public boolean delete(String name) {
        try{
            line.deleteStation(name);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
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
