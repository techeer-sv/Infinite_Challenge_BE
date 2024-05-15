package subway.controller;

import subway.config.handler.SubwayException;
import subway.service.InitManager;
import subway.service.StationManager;

// 역을 관리하는 컨트롤러
public class StationController extends ManageController{
    static StationManager stationManager;
    static SubwayException subwayException;

    StationController(final InitManager manager){
        stationManager = manager.getStationManager();
        subwayException = manager.getSubwayException();
    }

    @Override
    public boolean register(){
        ask.orderWhere(REGISTER, STATION);
        try{
            String station = br.readLine();
            boolean result = stationManager.isValid(station);
            String message = makeString.infoMessage(REGISTER, result); // "지하철 역이 등록되었습니다." 출력
            response.printInfo(message);
            return false;
        }catch (Exception e){
            e.printStackTrace();
            subwayException.unexpected();
        }
        return true;
    }

    @Override
    public boolean delete(){
        // db 접근해서 데이터 삭제하는 서비스와 연결
        ask.orderWhere(DELETE,  STATION);
        try{
            String command = br.readLine();
            boolean result = stationManager.delete(command);
            String message = makeString.infoMessage(DELETE, result);
            response.printInfo(message);
        }catch (Exception e){
            subwayException.unexpected();
            return false;
        }
        return true;
    }

    public boolean read(){
        response.printTitle("역 목록");
        StringBuilder list = stationManager.read();
        response.printList(list);
        return true;
    }
}
