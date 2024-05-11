package subway.service;

public abstract class Managerable {
    public abstract boolean register(String command);
    public abstract boolean delete(String name);
    public abstract StringBuilder read();
}
