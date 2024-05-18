package subway.service.utils;

import subway.config.handler.InputException;
import subway.config.handler.SubwayException;
import subway.domain.Line;

import static subway.controller.utils.Constants.LINE;
import static subway.controller.utils.Constants.STATION;
import static subway.service.utils.Constants.lineRepo;
import static subway.service.utils.Constants.stationRepo;

public class Verify {
    SubwayException subwayException = new SubwayException();
    InputException inputException = new InputException();

    public boolean isEmpty(final String station) {
        if(subwayException.isBack(station) == true) return false; // TODO: 종료시키는 에러? 커스텀?
        return isStationEmpty(station);
    }
    public boolean isEmpty(final String type, final String name){
        if(subwayException.isBack(name) == true) return false; // TODO: 종료시키는 에러? 커스텀?
        if(type.equals(STATION)) return isStationEmpty(name);
        if(type.equals(LINE)) return isValidLine(LINE, name);
        return true;
    }

    boolean isStationEmpty(final String station){
        if(stationRepo.getStationByName(station) == null ) return true;
        return false;
    }

    public boolean isValidLine(String target, String name){
        if(lineRepo.getLineByName(name) != null ) return false;
        return true;
    }

    public boolean lineEqualStation(String line){
        if(stationRepo.getStationByName(line) != null) {
            inputException.lineEqualStation();
            return true;
        }
        return false;
    }
    public boolean lineHaveStation(final String lName, final String sName){
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
