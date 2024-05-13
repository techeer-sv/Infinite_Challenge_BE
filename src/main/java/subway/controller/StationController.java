package subway.controller;

import subway.config.constants.views.Methods;
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
    public void sendRequest(String command){
        if(command.equals(Methods.등록.getCommand())){
            register();
            return;
        }
        if(command.equals(Methods.삭제.getCommand())){
            delete();
            return;
        }
        if(command.equals(Methods.조회.getCommand())){
            read();
            return;
        }
        if(command.equals("B")){
            return;
        }
        subwayException.notValidCommand();
    }

    @Override
    public void register(){
        ask.Name("등록", "역");
        try{
            String station = br.readLine();
            boolean result = stationManager.isValid(station);
            String message = makeString.infoMessage("등록", result); // "지하철 역이 등록되었습니다." 출력
            response.printInfo(message);
        }catch (Exception e){
            subwayException.unexpected();
        }
    }

    @Override
    public void delete(){
        // db 접근해서 데이터 삭제하는 서비스와 연결
        ask.Name("삭제", "역");
        try{
            String command = br.readLine();
            boolean result = stationManager.delete(command);
            String message = makeString.infoMessage("삭제", result);
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
