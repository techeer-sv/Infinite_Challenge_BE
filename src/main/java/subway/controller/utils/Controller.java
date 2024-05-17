package subway.controller.utils;

public interface Controller {
    static final Methods method = new Methods();

    public boolean register();
    public boolean delete();
    public boolean read();
}
