package subway;

import java.util.Scanner;

import subway.common.AppConfig;
import subway.controller.MainController;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        AppConfig appConfig = new AppConfig();
        MainController mainController = appConfig.mainController(scanner);
        mainController.run();
    }
}
