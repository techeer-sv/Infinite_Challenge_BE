package subway.service;

import subway.config.constants.Targets;
import subway.domain.Line;
import subway.domain.Station;
import subway.service.utils.LineMakeString;

import java.util.List;

import static subway.service.InitSubwayValues.*;

public class LineManager implements Managerable {
    LineMakeString makeString = new LineMakeString();
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
    boolean isValidLine(final String line){
        if(subwayException.isBack(line) == true) return false; // TODO: 종료시키는 에러? 커스텀?
        if(lineRepo.getLineByName(line) == null ) return true;
        return false;
    }

    boolean isStationEmpty(final String station){
        if(stationRepo.getStationByName(station) == null ) return true;
        return false;
    }
    public Line setLine(final String name){
        Line node = new Line(name);
        lineRepo.addLine(node);
        return node;
    }

    public void setStations(final String name, final String upperStation, final String bottomStation){
        Line line = setLine(name);
        Station upper = stationManager.getByStationName(upperStation);
        Station bottom = stationManager.getByStationName(bottomStation);
        upper.addLine(line);
        bottom.addLine(line);
        line.setStations(upper, bottom);
    }

    @Override
    public boolean delete(final String name) {
        Line line = lineRepo.getLineByName(name);
        for(int i=0;i<line.getSize();i++){
            Station node = line.getStation(i);
            node.deleteLine(line);
        }
        return lineRepo.deleteLineByName(name);
    }

    @Override
    public StringBuilder read() {
        StringBuilder sb = new StringBuilder();
        for(Line line: lineRepo.lines()){
            String name = line.getName();
            sb.append(makeString.lines(name)).append("\n");
        }
        return sb;
    }

    public StringBuilder getStationLines(){
        StringBuilder sb = new StringBuilder();
        List<Line> lineList = lineRepo.lines();
        for(Line line:lineList){
            String rail = line.getName();
            String title = makeString.title(rail);
            sb.append(title);
            sb.append(line.stationList()).append("\n");
        }
        return sb;
    }
}
