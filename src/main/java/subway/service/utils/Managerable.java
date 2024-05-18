package subway.service.utils;

import subway.config.handler.SubwayException;

public interface Managerable{
    public boolean delete(final String name);
    public StringBuilder read();
    static final SubwayException subwayException = new SubwayException();

    public boolean isEmpty(String type,String node);
}
