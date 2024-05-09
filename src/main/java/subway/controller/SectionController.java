package subway.controller;

import subway.service.LineManager;
import subway.service.SectionManager;
import subway.service.StationManager;

public class SectionController extends ManageController{
    private static StationManager stationManager = new StationManager();
    private static LineManager lineManager = new LineManager();
    private static SectionManager sectionManager = new SectionManager();
    @Override
    public void work() {
        ask.WhatToManage("구간");
        ask.Function();
        try{
            String command = br.readLine();
            if(command.equals("1")){ // 등록
                register();
                return;
            }
            if(command.equals("2")){ // 삭제
                delete();
                return;
            }
            if(command.equals("B")){ // 되돌아가기
                return;
            }
            // 에러 발생시키
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void register() { // 노선, 역 이름, 순서 입력 받고 등록
        ask.orderWhat("노선");
        String line = getLine();

        ask.orderWhat("역 이름");
        String station = getStation();

        ask.orderWhere();
        int index = getIndex();

        sectionManager.insertSection(line, station, index);
    }

    public String getLine(){
        try{
            return br.readLine();
        }catch (Exception e){
            System.out.println("존재하지 않는 노선입니다.");
            e.printStackTrace();
        }
        return null;
    }
    public String getStation(){
        try{
            return br.readLine();
        }catch (Exception e){
            System.out.println("존재하지 않는 역입니다.");
            e.printStackTrace();
        }
        return null;    }

    public int getIndex(){
        try{
            int index = Integer.parseInt(br.readLine());
            return index;
        } catch (Exception e){
            System.out.println("입력값을 확인해주세요.");
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void delete() {

    }
}
