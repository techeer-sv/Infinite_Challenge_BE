package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import subway.constant.message.ErrorMessage;

public class StationRepository {
    private final List<Station> stations = new ArrayList<>();

    public List<Station> getAll() {
        return Collections.unmodifiableList(stations);
    }

    public void save(final Station station) {
        if (stations.stream()
                    .anyMatch(element -> element.equals(station))) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PREFIX.toMessage() + "중복된 지하철역은 입력될 수 없습니다.");
        }
        stations.add(station);
    }

    public void delete(final String name) {
        if (!deleteStation(name)) {
            throw new IllegalStateException(ErrorMessage.ERROR_PREFIX.toMessage() + "없는 역을 입력했습니다.");
        }
    }

    private boolean deleteStation(final String name) {
        return stations.removeIf(station -> station.isEqualsByName(name));
    }

    public Station getByName(final String name) {
        return stations.stream()
                       .filter(e -> e.isEqualsByName(name))
                       .findFirst()
                       .orElseThrow(() -> new IllegalStateException("이름에 해당하는 역이 없습니다."));
    }
}
