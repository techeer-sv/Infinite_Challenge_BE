package subway.controller;

import subway.config.constants.views.Targets;
import subway.config.handler.SubwayException;
import subway.service.InitManager;
import subway.view.AskView;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainController {
    private AskView ask;
    private StationController stationController;
    private LineController lineController;
    private SectionController sectionController;
    private MapController mapController;
    private static SubwayException subwayException;
    private static Targets LINE = Targets.LINE;
    private static Targets STATION = Targets.STATION;
    private static Targets SECTION = Targets.SECTION;
    private static Targets MAP = Targets.MAP;


    public MainController() {
        ask = new AskView();
        InitManager manager = new InitManager();
        stationController = new StationController(manager);
        lineController = new LineController(manager);
        sectionController = new SectionController(manager);
        mapController = new MapController(manager);
        subwayException = manager.getSubwayException();
    }

    public void headController() throws Exception {
        ask.printMain();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command = br.readLine();
        if (command.equals("Q")) {
            System.out.println(" 안녕히 가세요. ");
            return;
        }
        try{
            CoreController(command);
        }catch (Exception e){
            subwayException.unexpected();
        }
        headController();
    }

    public void CoreController(final String line) {
        int command = Integer.parseInt(line);
        if (command == STATION.getCommand()) {
            stationController.work(stationController, STATION.getTarget());
            return;
        }
        if (command == LINE.getCommand()) {
            lineController.work(lineController, LINE.getTarget());
            return;
        }
        if (command == SECTION.getCommand()) {
            sectionController.work(sectionController, SECTION.getTarget());
            return;
        }
        if(command== MAP.getCommand()){
            mapController.work();
            return;
        }
        subwayException.notValidCommand();
    }
}
