package subway.controller.subControllers;

import subway.config.constants.Targets;
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
        String upper, bottom, message;
        String line = method.getLine(REGISTER, LINE);
        try {
            if (lineManager.isEmpty(Targets.LINE.getTarget(), line) != true) {
                inputException.alreadyCreatedLine();
                return false;
            }
            if(lineManager.lineEqualStation(line)) {
                inputException.lineEqualStation();
                return false;
            }
            upper = method.getStation(lineManager, REGISTER, UPPER);
            bottom = method.getStation(lineManager, REGISTER, BOTTOM);
            lineManager.setStations(line, upper, bottom);
        } catch (IllegalArgumentException e) {
            inputException.noStation();
            return false;
        }
        message= makeString.infoMessage(REGISTER, LINE, true);
        System.out.println(message);
        return true;
    }

    @Override
    public boolean delete() {
        String message;
        boolean result=false;
        ask.orderWhere(DELETE, LINE);
        try {
            String command = method.getUserInput();
            result = lineManager.delete(command);
        } catch (Exception e) {
            subwayException.noLine();
            return false;
        }
        message=makeString.infoMessage(DELETE,LINE, result);
        System.out.println(message);
        return true;
    }

    public boolean read() {
        response.printTitle("지하철 노선도");
        StringBuilder list = lineManager.read();
        response.printList(list);
        return true;
    }
}
