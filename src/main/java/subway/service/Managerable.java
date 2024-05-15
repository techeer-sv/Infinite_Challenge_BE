package subway.service;

public interface Managerable {
    public boolean isEmpty(final String command);
    public boolean delete(final String name);
    public StringBuilder read();
}
