package subway.controller;

import subway.domain.LineService;
import subway.domain.StationService;
import subway.view.InputView;
import subway.view.OutputView;

public class MainController {
    private final OutputView outputView;
    private final InputView inputView;
    private final StationService stationService;
    private final LineService lineService;

    public MainController() {
        outputView = new OutputView();
        inputView = new InputView();
        stationService = new StationService(outputView, inputView);
        lineService = new LineService(outputView, inputView);
    }

    public void run(){
        while (true){
            outputView.mainPage();
            String input = inputView.selectFunction();

            if(input.equals("1")){
                stationService.manage();
                continue;
            }
            if(input.equals("2")){
                lineService.manage();
                continue;
            }

        }
    }
}
