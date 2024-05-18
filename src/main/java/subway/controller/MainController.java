package subway.controller;

import subway.config.handler.SubwayException;
import subway.controller.subControllers.LineController;
import subway.controller.subControllers.MapController;
import subway.controller.subControllers.SectionController;
import subway.controller.subControllers.StationController;
import subway.controller.utils.CheckCommand;
import subway.controller.utils.Constants;
import subway.controller.utils.GetUserInput;
import subway.service.InitSubwayValues;
import subway.view.AskView;

public class MainController implements Constants {
    private AskView ask;
    private StationController station;
    private LineController line;
    private SectionController section;
    private MapController map;
    private static SubwayException subwayException;
    private CheckCommand checkCommand = new CheckCommand();
    private GetUserInput method=new GetUserInput();


    public MainController() {
        ask = new AskView();
        InitSubwayValues manager = new InitSubwayValues();
        createSubControllers(manager);
        subwayException = manager.getSubwayException();
    }

    public void createSubControllers(InitSubwayValues manager) {
        station = new StationController(manager);
        line = new LineController(manager);
        section = new SectionController(manager);
        map = new MapController(manager);
    }

    public void startService(int tryCount) {
        if (tryCount == 3) return;
        ask.manageTarget();
        String node = method.getUserInput();
        if(checkCommand.isValidInteger(node,false)){
            node = repeatService(node);
        }
        if (!checkCommand.isQ(node)) reService(tryCount);
    }

    public String repeatService(String node){
        do {
            int command = checkCommand.strToInt(node);
            serviceOn(command);
            ask.manageTarget();
            node = method.getUserInput();
        } while (checkCommand.isValidInteger(node, false));
        return node;
    }


    public boolean serviceOn(int node) {
        try {
            commandMapping(node);
            return true;
        } catch (SubwayException e) {
            subwayException.isNotUnder4OrQ(); // 에러 메시지 변경하기, while 조건문에서 검증 마침
        }
        return false;
    }

    public void reService(int tryCount) {
        StringBuilder sb = new StringBuilder();
        sb.append("오류가 발생했습니다.") // view 랑 연결해도 될 것 같은데
                .append("\n남은 시도 횟수 : ")
                .append(2-tryCount).append("회");
        System.out.println(sb);
        startService(tryCount + 1);
    }

    public boolean commandMapping(int target) {
        if (target == STATION_COMMAND) {
            return station.work(station, STATION, false);
        }
        if (target == LINE_COMMAND) {
            return line.work(line, LINE, false);
        }
        if (target == SECTION_COMMAND) {
            return section.work(section, SECTION, true);
        }
        if (target == MAP_COMMAND) {
            return map.work();
        }
        return false;
    }

    public void closeService(){
        method.closeBuffer();
    }
}
