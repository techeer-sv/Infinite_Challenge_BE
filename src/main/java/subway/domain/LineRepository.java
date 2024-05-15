package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(final Line line) {
        lines.add(line);
    }

    public static void addLine(final Line line, final Station station, final int index) {
        line.addStation(station, index);
    }

    public static boolean deleteLineByName(final String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name) && line.getSize()>2);
    }

    public static Line getLineByName(final String name) {
        for (Line line : lines) {
            if (line.getName().equals(name)) {
                return line;
            }
        }
        return null;
    }
}
