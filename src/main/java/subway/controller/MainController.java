package subway.controller;

import subway.config.handler.SubwayException;
import subway.service.DataManager;
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

    public MainController() {
        ask = new AskView();
        DataManager manager = new DataManager();
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
            int validCommand = Integer.parseInt(command);
            CoreController(validCommand);
        }catch (Exception e){
            System.out.println("[ERROR] 예상치 못한 에러가 발생했습니다.");
        }
        // command 가 유효한 명령이 아닐 경우 코드 추가
        headController();
    }

    // 생성자와 함께 출력과 서비스를 제공하려 했는데 무슨 일 할 때마다 클래스 생성하는 것은 비효율적인 것 같다. 메소드로 바꾸자. 아니 이게 맞나?
    public void CoreController(final int command) {
        if (command == 1) {
            stationController.work();
            return;
        }
        if (command == 2) {
            lineController.work();
            return;
        }
        if (command == 3) {
            sectionController.work();
            return;
        }
        if(command==4){
            mapController.work();
            return;
        }
        subwayException.notValidCommand();
    }
}
