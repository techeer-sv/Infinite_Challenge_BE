package subway.controller;

public class StationController extends ManageController{
    private static MainController mainController = new MainController();
    @Override
    public void work(){
        ask.WhatToManage("역");
        ask.Function();
        try{
            String command = br.readLine();
            // command 내용 확인하고 맞는 처리와 연결
            if(command.equals("1")){
                registerControll();
                mainController.headController();
                return;
            }
            if(command.equals("2")){
                delete();
                mainController.headController();
                return;
            }
            if(command.equals("3")){
                requestStations();
                mainController.headController();
                return;
            }
            if(command.equals("B")){
                mainController.headController();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void registerControll(){
        ask.Name("등록", "역");
        try{
            String station = br.readLine();
            register(station);
            // "지하철 역이 등록되었습니다." 출력
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void register(String station){
        // db 접근해서 데이터 삽입하는 서비스와 연결
        System.out.println("register 메서드 안이다.");
    }

    @Override
    public void delete(){
        // db 접근해서 데이터 삭제하는 서비스와 연결
        ask.Name("삭제", "역");
        try{
            String command = br.readLine();
            System.out.println("delete 메서드 안이다.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void requestStations() throws Exception{
        // 역 목록을 출력하는 서비스 코드
        System.out.println("requestStations 메서드 안이다.");
    }
}
