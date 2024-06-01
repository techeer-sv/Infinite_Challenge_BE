package subway.domain;

import subway.global.error.ErrorMessage;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return Objects.equals(name, station.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
