package subway.controller.subControllers;

import subway.config.constants.Targets;
import subway.config.handler.InputException;
import subway.config.handler.SubwayException;
import subway.controller.utils.ClassifyMethods;
import subway.service.InitSubwayValues;
import subway.service.StationManager;


// 역을 관리하는 컨트롤러
public class StationController extends ClassifyMethods {
    static StationManager stationManager;
    SubwayException subwayException;
    InputException inputException = new InputException();
    public StationController(final InitSubwayValues manager) {
        stationManager = manager.getStationManager();
        subwayException = manager.getSubwayException();
    }

    @Override
    public boolean register() {
        ask.orderIndex(REGISTER, STATION);
        String station = method.getUserInput();
        if(stationManager.register(station)){
            return setPrint.printResult(REGISTER, STATION, true);
        }
        return setPrint.printResult(REGISTER, STATION, false);
    }

    @Override
    public boolean delete() {
        ask.orderIndex(DELETE, STATION);
        String command = method.getUserInput();
        if(method.isEmpty(STATION, command)) {
            inputException.noStation();
            return false;
        }
        boolean result = deleteStation(command);
        return setPrint.printResult(DELETE, STATION, result);
    }

    boolean deleteStation(String command){
        try {
            return stationManager.delete(command);
        } catch(IllegalArgumentException e){
            inputException.underTwoStation();
        }catch (Exception e) {
            inputException.unExpectedError();
        }
        return false;
    }

    public boolean read() {
        response.printTitle("역 목록");
        StringBuilder list = stationManager.read();
        response.printList(list);
        return true;
    }
}
