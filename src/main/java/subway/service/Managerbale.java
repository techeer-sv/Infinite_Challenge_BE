package subway.service;

import subway.domain.LineRepository;
import subway.domain.StationRepository;

public abstract class Managerbale {
    StationRepository stationRepo = new StationRepository();
    LineRepository lineRepo = new LineRepository();
    public abstract boolean register(String command);
    public abstract void delete(String name);
    public abstract StringBuilder read();

    public void goBack() {
        return;
    }
}
