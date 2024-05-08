package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;

import java.util.List;

public class LineManager extends Managerbale{
    @Override
    public boolean register(String name) {
        Line created = new Line(name);
        lineRepo.addLine(created);
        return true;
    }

    public void setStations(String name, String upperStation, String bottomStation){
        Line created = new Line(name);
        lineRepo.addLine(created);
        // upper, bottom 을 찾고 아래 매개변수에 대입하는 코드 추가
        created.setStations(new Station(upperStation), new Station(bottomStation));
    }

    @Override
    public void delete(String name) {
        lineRepo.deleteLineByName(name);
    }

    @Override
    public StringBuilder read() {
        StringBuilder sb = new StringBuilder();

        sb.append("");
        return sb;
    }

    public List<Line> readLines(){
        return lineRepo.lines();
    }
}
