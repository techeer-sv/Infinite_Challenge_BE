package subway.controller.utils;

import subway.view.AskView;
import subway.view.ResponseView;
import subway.view.util.MakeString;

public interface Controller {
    static final Methods method = new Methods();

    public boolean register();
    public boolean delete();
    public boolean read();
}
