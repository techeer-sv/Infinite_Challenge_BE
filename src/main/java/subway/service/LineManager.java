package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;

public class LineManager extends Managerbale{
    static final LineRepository lineRepo = new LineRepository();
    static StationManager stationManager = new StationManager();

    @Override
    public boolean register(String name) {
        if(lineRepo.getLineByName(name) != null){
            return false;
        }
        lineRepo.addLine(new Line(name));
        return true;
    }
// Todo : 상행 종점, 하행 종점 입력 받기

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

//    public List<Line> readLines(){
//        return lineRepo.lines();
//    }
}
