package subway.controller;

import subway.domain.StationController;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class MainController {
    private final OutputView outputView;
    private final InputView inputView;
    private final StationController stationController;

    public MainController() {
        outputView = new OutputView();
        inputView = new InputView();
        stationController = new StationController(outputView, inputView);
    }

    public void run(){
        while (true){
            outputView.mainPage();
            String input = inputView.selectFunction();

            if(input.equals("1")){
                stationController.manage();
            }
        }
    }
}
