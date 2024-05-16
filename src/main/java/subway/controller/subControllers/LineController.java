package subway.controller.subControllers;

import subway.config.handler.SubwayException;
import subway.controller.utils.ClassifyMethods;
import subway.service.InitSubwayValues;
import subway.service.LineManager;

public class LineController extends ClassifyMethods {
    static LineManager lineManager;
    private static SubwayException subwayException;

    public LineController(final InitSubwayValues manager) {
        lineManager = manager.getLineManager();
        subwayException = manager.getSubwayException();
    }

    @Override
    public boolean register() {
        String upper, bottom, message;
        try {
            String line = method.getLine(REGISTER, LINE);
            if (lineManager.isEmpty(line) != true) {
                subwayException.alreadyCreatedLine();
            }

            upper = method.getStation(lineManager, REGISTER, UPPER);
            bottom = method.getStation(lineManager, REGISTER, BOTTOM);
            if(upper == null || bottom == null){
                subwayException.noStation();
            }

            lineManager.setStations(line, upper, bottom);
        } catch (Exception e) {
            message= makeString.infoMessage(REGISTER, LINE,false);
            System.out.println(message);
            e.printStackTrace();
            subwayException.unexpected();
        }
        message= makeString.infoMessage(REGISTER, LINE, true);
        System.out.println(message);
        return true;
    }

    @Override
    public boolean delete() {
        String message;
        boolean result=false;
        // 노선 db 에서 삭제
        ask.orderWhere(DELETE, LINE);
        try {
            String command = method.getUserInput();
            result = lineManager.delete(command);
            message=makeString.infoMessage(DELETE,LINE, result);
        } catch (Exception e) {
            message=makeString.infoMessage(DELETE,LINE, result);
            System.out.println(message);
            subwayException.noLine();
            return false;
        }
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
