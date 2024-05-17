package subway.service.utils;

import subway.config.constants.Targets;
import subway.config.handler.SubwayException;
import subway.domain.Line;

import static subway.service.utils.Constants.lineRepo;
import static subway.service.utils.Constants.stationRepo;

public class Verify {
    SubwayException subwayException = new SubwayException();
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
    public Line getLine(String name){
        Line line = lineRepo.getLineByName(name);
        if(line == null) subwayException.noLine();
        return line;
    }

}
