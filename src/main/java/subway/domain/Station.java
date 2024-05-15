package subway.domain;

import java.util.List;

public class Station {
    private String name;
    //TODO : 노선 관리에서 연결시키기 -> 삭제 관련 기능추가 구현
    private List<Line>[] line;

    public Station(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
