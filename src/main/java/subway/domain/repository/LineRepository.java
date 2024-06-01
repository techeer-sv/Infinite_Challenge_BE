package subway.domain.repository;

import subway.domain.Line;
import subway.global.error.ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private final List<Line> lines = new ArrayList<>();

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public void addLine(Line line) {
        if(lines.stream().anyMatch(l -> l.getName().equals(line.getName()))) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LINE);
        }
        lines.add(line);
    }

    public boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public void clear() {
        lines.clear();
    }
}
