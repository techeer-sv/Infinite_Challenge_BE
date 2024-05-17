package subway.controller.subControllers;

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
        ask.orderWhere(REGISTER, STATION);
        boolean result = false;
        String station = method.getUserInput();
        try {
            result = stationManager.isEmpty(station);
        } catch (Exception e) {
            inputException.alreadyCreatedStation();
        }
        String message = makeString.infoMessage(REGISTER, STATION, result);
        response.printInfo(message);
        return result;
    }

    @Override
    public boolean delete() {
        ask.orderWhere(DELETE, STATION);
        String command = method.getUserInput();
        boolean result=false;
        try {
            result = stationManager.delete(command);
        } catch(IllegalArgumentException e){
            inputException.underTwoStation();
            return false;
        }catch (Exception e) {
            inputException.unExpectedError();
            return false;
        }
        String message = makeString.infoMessage(DELETE, STATION, result);
        response.printInfo(message);
        return true;
    }

    public boolean read() {
        response.printTitle("역 목록");
        StringBuilder list = stationManager.read();
        response.printList(list);
        return true;
    }
}
