package subway.controller;

import subway.view.Ask;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainController {
    Ask ask = new Ask();
    public MainController(){
        ask.Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String command = br.readLine();
            if(command.equals("Q")) {
                System.out.println(" 안녕히 가세요. ");
                return;
            }
            int validCommand = Integer.parseInt(command);
            CoreController(validCommand);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void CoreController(int command){
        if(command == 1) new StationController();
        if(command == 2) new LineController();
        if(command == 3) new SectionController();
    }
}
