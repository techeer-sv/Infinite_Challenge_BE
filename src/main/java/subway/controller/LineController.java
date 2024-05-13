package subway.controller;

import subway.config.constants.views.Methods;
import subway.config.constants.views.Targets;
import subway.config.handler.SubwayException;
import subway.service.DataManager;
import subway.service.LineManager;

public class LineController extends ManageController{
    static LineManager lineManager;
    private static SubwayException subwayException;
    public LineController(final DataManager manager){
        lineManager = manager.getLineManager();
        subwayException = manager.getSubwayException();
    }
    @Override
    public void work(){
        ask.WhatToManage("노선");
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
            // 에러 발생시키기
            subwayException.notValidCommand();
        }catch (Exception e){
            System.out.println("[ERROR] 예상치 못한 에러가 발생했습니다.");
        }
    }

    @Override
    public void register() {
        String command = Methods.등록.toString();
        // 새로운 노선 db 와 연동하여 생성하기
        ask.Name(command, "노선");
        try{
            String line = br.readLine();
            subwayException.isValidLength(line);
            boolean result = lineManager.register(line);

            ask.Name(command, Targets.UPPER.getTarget());
            String upper = br.readLine();
            ask.Name(command, "하행 종점역");
            String bottom = br.readLine();

            lineManager.setStations(line, upper, bottom);
            infoMessage(command, result);
        }catch (Exception e){
            System.out.println("[ERROR] 예상치 못한 에러가 발생했습니다.");
        }
    }

    public void infoMessage(final String work, final boolean result){
        StringBuilder sb = new StringBuilder();
        sb.append("노선이 ");
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
    public void delete() {
        // 노선 db 에서 삭제
        ask.Name("삭제", "노선");
        try{
            String command = br.readLine();
            boolean result = lineManager.delete(command);
            infoMessage("삭제", result);
        }catch (Exception e){
            System.out.println("[ERROR] 예상치 못한 에러가 발생했습니다.");
        }
    }

    public void read(){
        response.printTitle("노선 목록");
        StringBuilder list = lineManager.read();
        response.printList(list);
    }
}
