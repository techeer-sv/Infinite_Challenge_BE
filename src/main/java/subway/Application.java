package subway;

import subway.common.AppConfig;

public class Application {
    public static void main(String[] args) {

        AppConfig.getInstance().subwayController().start();
    }
}
