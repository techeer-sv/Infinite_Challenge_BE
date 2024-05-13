package subway.controller;

import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.service.StationManager;
import subway.view.AskView;
import subway.view.ResponseView;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static subway.controller.StationController.subwayException;

public abstract class ManageController {
    AskView ask = new AskView();
    ResponseView response = new ResponseView();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public void work(String target){
        ask.WhatToManage(target);
        ask.Function();
        try{
            String command = br.readLine();
            sendRequest(command);
        }catch (Exception e){
            subwayException.unexpected();
        }
    }
     // 등록하기
     public abstract void sendRequest(String command);

     public abstract void register();
        // db 접근해서 데이터 삽입하는 서비스와 연결

    public abstract void delete();
        // db 접근해서 데이터 삭제하는 서비스와 연결

//    public void read(){};
}
