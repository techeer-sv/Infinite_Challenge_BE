package subway.service;

import subway.config.handler.SubwayException;
import subway.domain.Line;
import subway.domain.Station;
import subway.service.utils.LineMakeString;

import java.util.List;

import static subway.service.InitManager.*;

public class LineManager implements Managerable {
    LineMakeString makeString = new LineMakeString();
    SubwayException subwayException = new SubwayException();
    @Override
    public boolean isEmpty(final String name) {
        if(subwayException.isBack(name)){
            return false;
        }
        if(lineRepo.getLineByName(name) == null){
            return true;
        }
        return false;
    }

    public Line setStation(final String name){
        Line node = new Line(name);
        lineRepo.addLine(node);
        return node;
    }

    public void setStations(final String name, final String upperStation, final String bottomStation){
        Line line = setStation(name);
        Station upper = stationManager.getByName(upperStation);
        Station bottom = stationManager.getByName(bottomStation);
        line.setStations(upper, bottom);
    }

    @Override
    public boolean delete(final String name) {
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
