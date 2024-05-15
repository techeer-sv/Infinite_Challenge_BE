package subway.controller;

import subway.config.handler.SubwayException;
import subway.service.InitManager;
import subway.service.LineManager;

public class LineController extends ManageController {
    static LineManager lineManager;
    private static SubwayException subwayException;

    public LineController(final InitManager manager) {
        lineManager = manager.getLineManager();
        subwayException = manager.getSubwayException();
    }

    @Override
    public boolean register() {
        String upper, bottom, message;
        try {
            String line = method.getLine(REGISTER, LINE);
            if (lineManager.isValid(line) != true) return false; //TODO:  에러 커스텀

            upper = method.getStation(lineManager, REGISTER, UPPER);
            bottom = method.getStation(lineManager, REGISTER, BOTTOM);
            if(upper == null || bottom == null) return false; // TODO: ERROR 커스텀해서 적용해야겟다
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
            String command = br.readLine();// TODO: 존재하지 않는 노선을 받았을 때 예외처리 커스텀
            result = lineManager.delete(command);
            message=makeString.infoMessage(DELETE,LINE, result);
        } catch (Exception e) {
            message=makeString.infoMessage(DELETE,LINE, result);
            System.out.println(message);
            subwayException.unexpected();
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
