package subway.service;

import subway.config.handler.SubwayException;
import subway.domain.Line;
import subway.domain.Station;
import subway.service.utils.Managerable;
import subway.service.utils.Verify;

import static subway.service.InitSubwayValues.lineRepo;
import static subway.service.InitSubwayValues.stationRepo;

public class SectionManager extends Verify implements Managerable {
    private Line line=null;
    SubwayException subwayException =new SubwayException();

    public void insertSection(final String sName,final int index){
        Station station = stationRepo.getStationByName(sName);
        if(station == null) subwayException.noStation();
        lineRepo.addLine(line, station, index);
    }

    public Line getLine(String name){
        Line line = lineRepo.getLineByName(name);
        if(line == null) subwayException.noLine();
        this.line=line;
        return line;
    }

    @Override
    public boolean delete(final String station) {
        if(subwayException.isBack(station) == true) return true;
        if(line.deleteStation(station)) return true;
        subwayException.checkCommand();
        return false;
    }

    @Override
    public StringBuilder read() {
        StringBuilder sb = new StringBuilder();
        return sb;
    }
}
