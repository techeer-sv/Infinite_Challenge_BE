package subway.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Station {
    private String name;
    private List<Line> line = new LinkedList();
    private int canDelete = 0;

    public Station(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addLine(Line lineNode) {
        line.add(lineNode);
    }

    public void deleteLine(Line lineNode) {
        line.remove(lineNode);
    }

    public List getLine() {
        return this.line;
    }

    public boolean hasNoLine() {
        if (canDelete == 0) {
            return true;
        }
        return false;
    }

    public void canDelete() {
        this.canDelete -= 1;
    }

    public void neverDelete() {
        this.canDelete += 1;
    }
}
