package subway.controller;

import subway.config.handler.SubwayException;
import subway.controller.controllers.LineController;
import subway.controller.controllers.MapController;
import subway.controller.controllers.SectionController;
import subway.controller.controllers.StationController;
import subway.controller.utils.CheckCommand;
import subway.controller.utils.Constants;
import subway.service.InitSubwayValues;
import subway.view.AskView;

public class MainController implements Constants {
    private AskView ask;
    private StationController stationController;
    private LineController lineController;
    private SectionController sectionController;
    private MapController mapController;
    private static SubwayException subwayException;
    private CheckCommand isValidCommand = new CheckCommand();


    public MainController() {
        ask = new AskView();
        InitSubwayValues manager = new InitSubwayValues();
        prepareServer(manager);
        subwayException = manager.getSubwayException();
    }

    public void prepareServer(InitSubwayValues manager) {
        stationController = new StationController(manager);
        lineController = new LineController(manager);
        sectionController = new SectionController(manager);
        mapController = new MapController(manager);
    }

    public void headController(int tryCount) {
        String node;
        if (tryCount == 3) return;
        do {
            ask.printMain();
            node = isValidCommand.getCommand();
        } while (isValidCommand.isMainCommand(node) && serviceOn(node));
        if (!isValidCommand.isQ(node)) reService(tryCount);
    }


    public boolean serviceOn(String node) {
        int command = Integer.parseInt(node);
        try {
            commandMapping(command);
            return true;
        } catch (SubwayException e) {
            subwayException.isNotUnder4OrQ(); // 에러 메시지 변경하기, while 조건문에서 검증 마침
        }
        return false;
    }

    public void reService(int tryCount) {
        StringBuilder sb = new StringBuilder();
        sb.append("오류가 발생했습니다. 다시 시도해주세요.") // view 랑 연결해도 될 것 같은데
                .append("\n남은 시도 횟수 : ")
                .append(2-tryCount).append("회");
        System.out.println(sb);
        headController(tryCount+1);
    }

    public boolean commandMapping(int target) {
        if (target == STATION_COMMAND) {
            return stationController.work(stationController, STATION);
        }
        if (target == LINE_COMMAND) {
            return lineController.work(lineController, LINE);
        }
        if (target == SECTION_COMMAND) {
            return sectionController.work(sectionController, SECTION);
        }
        if (target == MAP_COMMAND) {
            return mapController.work();
        }
        return false;
    }
}
