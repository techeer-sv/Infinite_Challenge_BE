package subway.service;

import subway.config.handler.SubwayException;
import subway.domain.Line;
import subway.domain.Station;

import static subway.service.InitSubwayValues.lineRepo;
import static subway.service.InitSubwayValues.stationRepo;

public class SectionManager implements Managerable {
    private Line line;
    SubwayException subwayException =new SubwayException();
    @Override
    public boolean isEmpty(final String name) {
        if(subwayException.isBack(name) == true)
            return false;

        line = lineRepo.getLineByName(name);

        if(line == null)
            subwayException.noLine();
        return true;
    }

    public void insertSection(final String sName,final int index){
        Station station = stationRepo.getStationByName(sName);
        if(station == null) subwayException.noStation();
        lineRepo.addLine(line, station, index);
    }

    @Override
    public boolean delete(final String name) {
        if(subwayException.isBack(name) == true) return true;
        if(line.deleteStation(name)) return true;
        subwayException.checkCommand();
        return false;
    }

    @Override
    public StringBuilder read() {
        StringBuilder sb = new StringBuilder();
        return sb;
    }
}
