package subway.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Station {
    private String name;
    //TODO : 노선 관리에서 연결시키기 -> 삭제 관련 기능추가 구현
    private List<Line> line = new LinkedList();

    public Station(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void addLine(Line lineNode){
        line.add(lineNode);
    }
    public void deleteLine(Line lineNode){
        line.remove(lineNode);
    }

    public boolean hasNoLine(){
        if(line.size()==0){
            return true;
        }
        return false;
    }
}
