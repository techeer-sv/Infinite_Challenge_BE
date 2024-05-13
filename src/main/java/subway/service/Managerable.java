package subway.service;

public abstract class Managerable {
    public abstract boolean register(final String command);
    public abstract boolean delete(final String name);
    public abstract StringBuilder read();
}
