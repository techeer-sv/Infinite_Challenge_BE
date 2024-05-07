package subway.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subway {

    private static final int INDEX_ADDER = 1;
    private final Map<Line, List<Station>> subway;

    public Subway() {
        this.subway = new HashMap<>();
    }

    public Map<Line, List<Station>> getSubway() {
        return subway;
    }

    public void addNewSubwayLine(final Line line, final List<Station> stations) {
        subway.put(line, stations);
    }

    public void deleteSubwayByLine(final Line line) {
        subway.remove(line);
    }

    public void addStationByLine(final Line line, final Station station, final int stationIndex) {
        List<Station> stations = subway.get(line);
        if (stations.stream().anyMatch(e -> e.equals(station))) {
            throw new IllegalArgumentException("중복된 값을 저장할 수 없습니다.");
        }
        stations.add(stationIndex + INDEX_ADDER, station);

    }
}
