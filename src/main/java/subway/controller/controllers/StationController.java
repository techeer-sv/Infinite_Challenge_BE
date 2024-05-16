package subway.controller.controllers;

import subway.config.handler.SubwayException;
import subway.controller.utils.ClassifyMethods;
import subway.service.InitSubwayValues;
import subway.service.StationManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 역을 관리하는 컨트롤러
public class StationController extends ClassifyMethods {
    static StationManager stationManager;
    SubwayException subwayException;

    public StationController(final InitSubwayValues manager){
        stationManager = manager.getStationManager();
        subwayException = manager.getSubwayException();
    }

    @Override
    public boolean register(){
        ask.orderWhere(REGISTER, STATION);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            String station = br.readLine();
            boolean result = stationManager.isEmpty(station);
            String message = makeString.infoMessage(REGISTER, STATION,result);
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
        ask.orderWhere(DELETE,  STATION);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            String command = br.readLine();
            boolean result = stationManager.delete(command);
            String message = makeString.infoMessage(DELETE, STATION, result);
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
