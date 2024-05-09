package subway.controller;

import subway.service.LineManager;

public class LineController extends ManageController{
    static LineManager lineManager = new LineManager();
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
            // 에러 발생시키
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void register() {
        // 새로운 노선 db 와 연동하여 생성하기
        ask.Name("등록", "노선");
        try{
            String line = br.readLine();
            boolean result = lineManager.register(line);

            ask.Name("등록", "상행 종점역");
            String upper = br.readLine();
            ask.Name("등록", "하행 종점역");
            String bottom = br.readLine();

            lineManager.setStations(line, upper, bottom);
            infoMessage("등록", result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void infoMessage(String work, boolean result){
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
            e.printStackTrace();
        }
    }

    public void read(){
        response.printTitle("노선 목록");
        StringBuilder list = lineManager.read();
        response.printList(list);
    }
}
