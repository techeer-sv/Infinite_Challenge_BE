package subway.service;

import subway.domain.Line;
import subway.domain.Station;

import java.util.List;

public class SectionManager extends Managerbale{
    @Override
    public boolean register(String name) {
        return true;
    }

    public void insertSection(String name, int index){
        // 이미 해당 역이 등록되어 있는지 확인
        // 등록되지 않았으면
        Station created = new Station(name);
        List<Line> line = lineRepo.lines();

    }

    @Override
    public boolean delete(String name) {
        return true;
    }

    @Override
    public StringBuilder read() {
        StringBuilder sb = new StringBuilder();

        sb.append("");
        return sb;
    }

    @Override
    public void goBack() {

    }
}
