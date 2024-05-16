package subway.service;

import subway.config.handler.SubwayException;

public interface Managerable {
    public boolean isEmpty(final String command);
    public boolean delete(final String name);
    public StringBuilder read();
    static final SubwayException subwayException = new SubwayException();
}
