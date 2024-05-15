package subway.controller;

import subway.config.handler.SubwayException;
import subway.controller.utils.Constants;
import subway.service.InitManager;
import subway.view.AskView;

import java.io.IOException;

import static subway.controller.ManageController.br;

public class MainController implements Constants {
    private AskView ask;
    private StationController stationController;
    private LineController lineController;
    private SectionController sectionController;
    private MapController mapController;
    private static SubwayException subwayException;
    private static int command;


    public MainController() {
        ask = new AskView();
        InitManager manager = new InitManager();
        setControllers(manager);
        subwayException = manager.getSubwayException();
    }

    public void setControllers(InitManager manager) {
        stationController = new StationController(manager);
        lineController = new LineController(manager);
        sectionController = new SectionController(manager);
        mapController = new MapController(manager);
    }

    public void headController() throws Exception {
        while (true) {
            ask.printMain();
            String node = br.readLine();
            if (isEnd(node)) return;
            nextStep(node);
        }
    }

    public boolean isEnd(String node) throws IOException {
        if (node.equals("Q") || node.equals("q")) {
            System.out.println(" 안녕히 가세요. ");
            br.close();
            return true;
        }
        return false;
    }

    public void nextStep(String node) {
        try {
            if (!strToInt(node)) return;
            CoreController(command);
        } catch (SubwayException e) {
            subwayException.isNotUnder4OrQ();
        }
    }

    public boolean CoreController(int command) {
        if (command == STATION_COMMAND) {
            return stationController.work(stationController, STATION);
        }
        if (command == LINE_COMMAND) {
            return lineController.work(lineController, LINE);
        }
        if (command == SECTION_COMMAND) {
            return sectionController.work(sectionController, SECTION);
        }
        if (command == MAP_COMMAND) {
            return mapController.work();
        }
        throw new SubwayException();
    }

    public boolean strToInt(final String node) {
        try {
            command = Integer.parseInt(node);
            return true;
        } catch (NumberFormatException e) {
            subwayException.isNotUnder4OrQ();
        }
        return false;
    }
}
