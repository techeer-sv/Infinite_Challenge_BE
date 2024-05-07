package subway.controller;

import subway.view.AskView;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainController {
    AskView ask = new AskView();
    StationController stationController = new StationController();
    public MainController(){
        ask.Main();
        try{
            headController();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void headController() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command = br.readLine();
        if(command.equals("Q")) {
            System.out.println(" 안녕히 가세요. ");
            return;
        }
        int validCommand = Integer.parseInt(command);
        CoreController(validCommand);
        headController();
    }

    // 생성자와 함께 출력과 서비스를 제공하려 했는데 무슨 일 할 때마다 클래스 생성하는 것은 비효율적인 것 같다. 메소드로 바꾸자.
    public void CoreController(int command){
        if(command == 1) stationController.work();
        if(command == 2) new LineController();
        if(command == 3) new SectionController();
    }
}
