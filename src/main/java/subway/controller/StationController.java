package subway.controller;

import subway.config.constants.views.Targets;
import subway.config.handler.SubwayException;
import subway.service.DataManager;
import subway.service.StationManager;
import subway.view.util.MakeString;

// 역을 관리하는 컨트롤러
public class StationController extends ManageController{
    static StationManager stationManager;
    static SubwayException subwayException;
    static MakeString makeString;

    StationController(final DataManager manager){
        stationManager = manager.getStationManager();
        subwayException = manager.getSubwayException();
    }

    @Override
    public void register(){
        ask.Name(REGISTER, Targets.STATION.getTarget());
        try{
            String station = br.readLine();
            boolean result = stationManager.isValid(station);
            String message = makeString.infoMessage(REGISTER, result); // "지하철 역이 등록되었습니다." 출력
            response.printInfo(message);
        }catch (Exception e){
            subwayException.unexpected();
        }
    }

    @Override
    public void delete(){
        // db 접근해서 데이터 삭제하는 서비스와 연결
        ask.Name(DELETE,  STATION);
        try{
            String command = br.readLine();
            boolean result = stationManager.delete(command);
            String message = makeString.infoMessage(DELETE, result);
            response.printInfo(message);
        }catch (Exception e){
            subwayException.unexpected();
        }
    }

    public void read(){
        response.printTitle("역 목록");
        StringBuilder list = stationManager.read();
        response.printList(list);
    }
}
