package subway.controller.subControllers;

import subway.config.handler.InputException;
import subway.config.handler.SubwayException;
import subway.controller.utils.ClassifyMethods;
import subway.service.InitSubwayValues;
import subway.service.LineManager;

public class LineController extends ClassifyMethods {
    static LineManager lineManager;
    InputException inputException = new InputException();
    private static SubwayException subwayException;

    public LineController(final InitSubwayValues manager) {
        lineManager = manager.getLineManager();
        subwayException = manager.getSubwayException();
    }

    @Override
    public boolean register() {
        String line = method.getLine(REGISTER, LINE);
        if(!lineManager.haveSameName(line)) return false;
        if(!addSubStations(line)) return false;
        return setPrint.printResult(REGISTER, LINE, true);
    }

    public boolean addSubStations(String line){
        String upper, bottom;
        try {
            if(!lineManager.haveSameName(line)) return false;
            upper = method.getStation(lineManager, REGISTER, UPPER);
            bottom = method.getStation(lineManager, REGISTER, BOTTOM);
            return lineManager.setStations(line, upper, bottom);
        } catch (IllegalArgumentException e) {
            inputException.noStation();
        }
        return false;
    }

    @Override
    public boolean delete() {
        boolean result=false;
        ask.orderIndex(DELETE, LINE);
        try {
            String command = method.getUserInput();
            result = lineManager.delete(command);
        } catch (Exception e) {
            subwayException.noLine();
            return false;
        }
        return setPrint.printResult(DELETE, LINE, result);
    }

    public boolean read() {
        response.printTitle("지하철 노선도");
        StringBuilder list = lineManager.read();
        response.printList(list);
        return true;
    }
}
