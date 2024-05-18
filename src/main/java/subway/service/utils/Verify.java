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

    public boolean isEmptyName(final String name){
        if(isEmpty(LINE, name) == false) {
            inputException.alreadyCreatedLine();
            return false;
        }
        if(isEmpty(STATION, name) == false) {
            inputException.alreadyCreatedStation();
            return false;
        }
        return true;
    }

    public boolean isEmpty(final String type, final String name){
        if(subwayException.isBack(name) == true) return false; // TODO: 종료시키는 에러? 커스텀?
        if(type.equals(STATION)) return isEmptyStation(name);
        if(type.equals(LINE)) return isEmptyLine(name);
        return true;
    }

    public boolean isEmptyStation(final String station){
        if(stationRepo.getStationByName(station) == null ) return true;
        return false;
    }

    public boolean isEmptyLine(String name){
        if(lineRepo.getLineByName(name) == null ) return true;
        return false;
    }

    public Line getLine(String name){
        Line line = lineRepo.getLineByName(name);
        if(line == null) subwayException.noLine();
        return line;
    }

}
