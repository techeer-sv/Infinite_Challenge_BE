package subway.service;

import subway.domain.Line;
import subway.domain.Station;
import subway.service.util.LineMakeString;

import java.util.List;

import static subway.service.DataManager.*;

public class LineManager extends Managerable {
    LineMakeString makeString = new LineMakeString();
    @Override
    public boolean register(final String name) {
        if(lineRepo.getLineByName(name) != null){
            return false;
        }
        lineRepo.addLine(new Line(name));
        return true;
    }

    public void setStations(final String name, final String upperStation, final String bottomStation){
        Line line = lineRepo.getLineByName(name);
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
        StringBuilder sb = new StringBuilder(); // 반복되는데 String으로바꿀까. 반환값 바꾸려면 이것저것 많이 건들어야 할 듯
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
