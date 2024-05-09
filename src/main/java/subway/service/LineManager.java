package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;

public class LineManager extends Managerbale{
    static LineRepository lineRepo = new LineRepository();
    @Override
    public boolean register(String name) {
        if(lineRepo.getLineByName(name) != null){
            return false;
        }
        lineRepo.addLine(new Line(name));
        return true;
    }
// Todo : 상행 종점, 하행 종점 입력 받기

//    public void setStations(String name, String upperStation, String bottomStation){
//        Line created = new Line(name);
//        lineRepo.addLine(created);
//        // upper, bottom 을 찾고 아래 매개변수에 대입하는 코드 추가
//        created.setStations(new Station(upperStation), new Station(bottomStation));
//    }

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
