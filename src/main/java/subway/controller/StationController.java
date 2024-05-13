package subway.controller;

import subway.config.constants.views.Methods;
import subway.config.constants.views.Prefixes;
import subway.config.constants.views.Targets;
import subway.config.handler.SubwayException;
import subway.service.DataManager;
import subway.service.StationManager;

// 역을 관리하는 컨트롤러
public class StationController extends ManageController{
    static StationManager stationManager;
    static SubwayException subwayException;
    String prefix = Prefixes.ERROR.getPrefix(); // 모든 변수의 인스턴스가 저장하는 클래스를 만들어?

    StationController(final DataManager manager){
        stationManager = manager.getStationManager();
        subwayException = manager.getSubwayException();
    }
    @Override
    public void work(){ // 이 부분을 모듈로 빼버릴까. work 의 매개변수에 따라서 역, 노선, 구간 나눠서 서비스 제공하기?
        ask.WhatToManage(Targets.STATION.getTarget());
        ask.Function();
        try{
            String command = br.readLine();
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
            // 에러 발생시키
            subwayException.notValidCommand();
        }catch (Exception e){
            System.out.println(prefix+"예상치 못한 에러가 발생했습니다.");
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
            System.out.println(prefix+"예상치 못한 에러가 발생했습니다.");
        }
    }
    public void infoMessage(final String work, final boolean result){
        StringBuilder sb = new StringBuilder();
        sb.append("지하철 역이 "); // 쓸데없이 긴 것 같은데 string 다루는 모듈을 따로 만들까. controller 기능이 잘 안보이는 것 같음
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
            System.out.println(prefix + "예상치 못한 에러가 발생했습니다.");
        }
    }

    public void read(){
        response.printTitle("역 목록");
        StringBuilder list = stationManager.read();
        response.printList(list);
    }
}
