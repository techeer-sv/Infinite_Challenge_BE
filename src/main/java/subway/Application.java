package subway;

import subway.controller.MainController;
public class Application {
    public static void main(String[] args) throws Exception {
        MainController main = new MainController();
        main.headController(0);
        System.out.println(" 안녕히 가세요. ");
    }
}
