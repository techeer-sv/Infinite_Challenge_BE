package subway.domain;

import subway.global.error.ErrorMessage;

public class Station {
    private final String name;

    public Station(String name) {
        if(name == null || name.length() < 2) {
            throw new IllegalArgumentException(ErrorMessage.STATION_TOO_SHORT);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
