package subway.service;

import subway.config.handler.InputException;
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
    InputException inputException = new InputException();

    public void insertSection(final String sName,final int index){
        Station station = stationRepo.getStationByName(sName);
        if(station == null) subwayException.noStation();
        lineRepo.addLine(line, station, index-1);
    }

    public Line getLine(String name){
        Line line = lineRepo.getLineByName(name);
        if(line == null) subwayException.noLine();
        this.line=line;
        return line;
    }

    public boolean isDeletable(String name){
        Line line = lineRepo.getLineByName(name);
        if(line.getSize()>2) return true;
        return false;
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

    public boolean isEmptySpace(String line, String station){
        if(isEmptyStation(station)){ // 등록 : 참
            inputException.noStation();
            return true;
        }
        if(isEmptyLine(line)){ // 등록: 참
            inputException.noCreatedLine();
            return true;
        }
//        inputException.noSuchLine();
        return false;
    }

    public boolean lineHaveStation(final String lName, final String sName){
        Line line = getLine(lName);
        if(line.haveStation(sName)){
            return true;
        }
        return false;
    }
}
