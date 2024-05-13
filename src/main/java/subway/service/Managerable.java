package subway.service;

public abstract class Managerable {
    public abstract boolean isValid(final String command);
    public abstract boolean delete(final String name);
    public abstract StringBuilder read();
}
