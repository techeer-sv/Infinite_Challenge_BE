package subway.controller;

import subway.domain.*;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;
import java.util.Map;

public class MainController {
    private final OutputView outputView;
    private final InputView inputView;
    private final StationService stationService;
    private final LineService lineService;
    private final SectionService sectionService;

    public MainController() {
        outputView = new OutputView();
        inputView = new InputView();
        stationService = new StationService(outputView, inputView);
        lineService = new LineService(outputView, inputView);
        sectionService = new SectionService(outputView, inputView);
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
            if(input.equals("3")){
                sectionService.manage();
                continue;
            }
            if(input.equals("4")){
                lineService.listALl();
                continue;
            }
            if(input.equals("Q")) return;


        }
    }


}
