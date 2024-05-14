package subway.domain;

import java.util.List;

public class Station {
    private String name;
    private List<Line>[] line;

    public Station(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    // 추가 기능 구현
}
