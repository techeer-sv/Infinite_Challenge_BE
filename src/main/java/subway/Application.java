package subway;

import subway.controller.MainController;
public class Application {
    public static void main(String[] args) {
        try{
            MainController main = new MainController();
            main.headController(0);
            System.out.println(" 안녕히 가세요. ");
        } catch (Exception e){
            System.err.println("에러가 발생했습니다. 관리자에게 문의해주세요.");
        }
    }
}
