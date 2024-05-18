package subway.controller.utils;

public interface Controller {
    static final GetUserInput method = new GetUserInput();

    public boolean register();
    public boolean delete();
    public boolean read();
}
