package subway.controller;

import subway.config.handler.SubwayException;
import subway.service.DataManager;
import subway.service.StationManager;

// 역을 관리하는 컨트롤러
public class StationController extends ManageController{
    static StationManager stationManager;
    static SubwayException subwayException;

    StationController(DataManager manager){
        stationManager = manager.getStationManager();
        subwayException = manager.getSubwayException();
    }
    @Override
    public void work(){
        ask.WhatToManage("역");
        ask.Function();
        try{
            String command = br.readLine();
            if(command.equals("1")){
                register();
                return;
            }
            if(command.equals("2")){
                delete();
                return;
            }
            if(command.equals("3")){
                read();
                return;
            }
            if(command.equals("B")){
                return;
            }
            // 에러 발생시키
            subwayException.notValidCommand();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void register(){
        ask.Name("등록", "역");
        try{
            String station = br.readLine();
            subwayException.isValidLength(station);
            boolean result = stationManager.register(station);
            // "지하철 역이 등록되었습니다." 출력
            infoMessage("등록", result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void infoMessage(String work, boolean result){
        StringBuilder sb = new StringBuilder();
        sb.append("지하철 역이 ");
        if(result == true){
            sb.append(work).append("되었습니다.");
        }
        if(result == false){
            sb.append(work).append("되지 않았습니다.");
        }
        String message = sb.toString();
        response.printInfo(message);
        sb.setLength(0);
    }

    @Override
    public void delete(){
        // db 접근해서 데이터 삭제하는 서비스와 연결
        ask.Name("삭제", "역");
        try{
            String command = br.readLine();
            boolean result = stationManager.delete(command);
            infoMessage("삭제", result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void read(){
        response.printTitle("역 목록");
        StringBuilder list = stationManager.read();
        response.printList(list);
    }

    public void requestStations() throws Exception{
        // 역 목록을 출력하는 서비스 코드
        System.out.println("requestStations 메서드 안이다.");
    }
}
