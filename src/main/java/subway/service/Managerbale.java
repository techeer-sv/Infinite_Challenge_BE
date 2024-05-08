package subway.service;

import subway.domain.LineRepository;
import subway.domain.StationRepository;

public abstract class Managerbale {
    public abstract boolean register(String command);
    public abstract boolean delete(String name);
    public abstract StringBuilder read();

    public void goBack() {
        return;
    }
}
