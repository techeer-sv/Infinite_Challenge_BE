package subway.service;

import subway.config.constants.Targets;
import subway.config.handler.SubwayException;
import subway.domain.Line;
import subway.domain.Station;

import static subway.service.InitSubwayValues.lineRepo;
import static subway.service.InitSubwayValues.stationRepo;

public class SectionManager implements Managerable {
    private Line line=null;
    SubwayException subwayException =new SubwayException();
    @Override
    public boolean isEmpty(final String station) {
        if(subwayException.isBack(station) == true) return false; // TODO: 종료시키는 에러? 커스텀?
        return isStationEmpty(station);
    }
    public boolean isEmpty(final String type, final String name){
        if(subwayException.isBack(name) == true) return false; // TODO: 종료시키는 에러? 커스텀?
        if(type.equals(Targets.STATION.getTarget())) return isStationEmpty(name);
        if(type.equals(Targets.LINE.getTarget())) return isValidLine(name);
        return true;
    }

    boolean isStationEmpty(final String station){
        if(stationRepo.getStationByName(station) == null ) return true;
        return false;
    }
    boolean isValidLine(final String line){
        if(subwayException.isBack(line) == true) return false; // TODO: 종료시키는 에러? 커스텀?
        if(lineRepo.getLineByName(line) == null ) return true;
        return false;
    }
    public boolean isValidLine(final String lName, final String sName){
        Line line = getLine(lName);
        if(line.haveStation(sName)){
            return false;
        }
        return true;
    }

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
