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
        String upper, bottom;
        // 새로운 노선 db 와 연동하여 생성하기
        try {
            String line = method.getLine(REGISTER, LINE);
            if (lineManager.isValid(line) != true) return false; // 에러 커스텀

            upper = method.getStation(lineManager, REGISTER, UPPER);
            bottom = method.getStation(lineManager, REGISTER, BOTTOM);
            if(upper == null || bottom == null) return false; // ERROR 커스텀해서 적용해야겟다
            lineManager.setStations(line, upper, bottom);
        } catch (Exception e) {
            infoMessage(REGISTER, false);
            e.printStackTrace();
            subwayException.unexpected();
        }
        infoMessage(REGISTER, true);
        return true;
    }


    // view 로 보내도 ㄱㅊ할듯? // TODO:  MakeString.java 에 비슷한 코드있음 확인 요망
    public void infoMessage(final String work, final boolean result) {
        StringBuilder sb = new StringBuilder();
        sb.append("노선이 ");
        if (result == true) {
            sb.append(work).append("되었습니다.");
        }
        if (result == false) {
            sb.append(work).append("되지 않았습니다.");
        }
        String message = sb.toString();
        response.printInfo(message);
    }

    @Override
    public boolean delete() {
        // 노선 db 에서 삭제
        ask.orderWhere(DELETE, LINE);
        try {
            String command = br.readLine();// 존재하지 않는 노선을 받았을 때 예외처리 커스텀
            boolean result = lineManager.delete(command);
            infoMessage(DELETE, result);
        } catch (Exception e) {
            subwayException.unexpected();
            return false;
        }
        return true;
    }

    public boolean read() {
        response.printTitle("지하철 노선도");
        StringBuilder list = lineManager.read();
        response.printList(list);
        return true;
    }
}
