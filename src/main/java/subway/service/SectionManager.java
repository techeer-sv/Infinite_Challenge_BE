package subway.service;

import subway.domain.Line;
import subway.domain.Station;

import java.util.List;

public class SectionManager extends Managerbale{
    @Override
    public void register(String name) {
    }

    public void insertSection(String name, int index){
        // 이미 해당 역이 등록되어 있는지 확인
        // 등록되지 않았으면
        Station created = new Station(name);
        List<Line> line = lineRepo.lines();

    }

    @Override
    public void delete(String name) {

    }

    @Override
    public void read() {

    }

    @Override
    public void goBack() {

    }
}
