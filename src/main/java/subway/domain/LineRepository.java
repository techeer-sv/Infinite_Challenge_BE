package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import subway.constant.message.ErrorMessage;

public class LineRepository {
    private final List<Line> lines = new ArrayList<>();

    public List<Line> getAll() {
        return Collections.unmodifiableList(lines);
    }

    public void save(final Line line) {
        if (lines.stream()
                 .anyMatch(element -> element.equals(line))) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PREFIX.toMessage() + "중복된 호선은 입력될 수 없습니다.");
        }
        lines.add(line);
    }

    public void delete(final String name) {
        if (!deleteLine(name)) {
            throw new IllegalStateException(ErrorMessage.ERROR_PREFIX.toMessage() + "없는 호선을 입력했습니다.");
        }
    }

    private boolean deleteLine(final String name) {
        return lines.removeIf(station -> station.isEqualsByName(name));
    }

    public Line getByName(final String name) {
        return lines.stream()
                    .filter(e -> e.isEqualsByName(name))
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("이름에 해당하는 노선이 없습니다."));
    }
}
