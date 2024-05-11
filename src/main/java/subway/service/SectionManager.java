package subway.service;

import subway.config.handler.SubwayException;
import subway.domain.Line;
import subway.domain.Station;

import static subway.service.DataManager.lineRepo;
import static subway.service.DataManager.stationRepo;

public class SectionManager extends Managerable {
    private Line line;
    private SubwayException subwayException;
    @Override
    public boolean register(String name) {
        line = lineRepo.getLineByName(name);
        if(line == null) subwayException.noLine();
        return true;
    }

    public void insertSection(String sName,int index){
        Station station = stationRepo.getStationByName(sName);
        if(station == null) subwayException.noStation();
        lineRepo.addLine(line, station, index);
    }

    @Override
    public boolean delete(String name) {
        if(line.deleteStation(name)) return true;
        subwayException.checkCommand();
        return false;
    }

    @Override
    public StringBuilder read() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        return sb;
    }
}
