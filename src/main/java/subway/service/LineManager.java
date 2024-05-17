package subway.service;

import subway.config.constants.Targets;
import subway.domain.Line;
import subway.domain.Station;
import subway.service.utils.LineMakeString;
import subway.service.utils.Managerable;
import subway.service.utils.Verify;

import java.util.List;

import static subway.service.InitSubwayValues.*;

public class LineManager extends Verify implements Managerable {
    LineMakeString makeString = new LineMakeString();
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
