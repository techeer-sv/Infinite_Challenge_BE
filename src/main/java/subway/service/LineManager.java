package subway.service;

import subway.domain.Line;
import subway.domain.Station;

import java.util.List;

import static subway.service.DataManager.*;

public class LineManager extends Managerable {
    @Override
    public boolean register(String name) {
        if(lineRepo.getLineByName(name) != null){
            return false;
        }
        lineRepo.addLine(new Line(name));
        return true;
    }

    public void setStations(String name, String upperStation, String bottomStation){
        Line line = lineRepo.getLineByName(name);
        Station upper = stationManager.getByName(upperStation);
        Station bottom = stationManager.getByName(bottomStation);

        line.setStations(upper, bottom);
    }

    @Override
    public boolean delete(String name) {
        return lineRepo.deleteLineByName(name);
    }

    @Override
    public StringBuilder read() {
        StringBuilder sb = new StringBuilder();
        for(Line line: lineRepo.lines()){
            sb.append("[INFO] " + line.getName()+"\n");
        }
        return sb;
    }

    public StringBuilder getStationLines(){
        StringBuilder sb = new StringBuilder();
        List<Line> lineList = lineRepo.lines();
        for(Line line:lineList){
            sb.append("[INFO] "+line.getName()).append("\n");
            sb.append("[INFO] ---").append("\n");
            sb.append(line.stationList()).append("\n");
        }
        return sb;
    }


//    public List<Line> readLines(){
//        return lineRepo.lines();
//    }
}
