package subway.controller;

import subway.view.Ask;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainController {
    Ask askView = new Ask();
    public MainController(){
        askView.Main();
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

    public void CoreController(int command){
        if(command == 1) new StationController();
        if(command == 2) new LineController();
        if(command == 3) new SectionController();
    }
}
