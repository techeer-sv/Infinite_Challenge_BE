package subway.domain.repository;

import subway.domain.Station;
import subway.global.error.ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public void addStation(Station station) {
        if(stations.stream().anyMatch(s -> s.getName().equals(station.getName()))){
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_STATION);
        }
        stations.add(station);
    }

    public boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public boolean isStationExist(String name) {
        return stations.stream().anyMatch(station -> station.getName().equals(name));
    }

    public void clear() {
        stations.clear();
    }
}
