package subway.controller;

import subway.config.constants.views.Methods;
import subway.view.AskView;
import subway.view.ResponseView;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static subway.controller.StationController.subwayException;

public abstract class ManageController implements Controller{
    AskView ask = new AskView();
    ResponseView response = new ResponseView();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public void work(Controller controller, String target){
        ask.WhatToManage(target);
        ask.Function();
        try{
            String command = br.readLine();
            sendRequest(controller, command);
        }catch (Exception e){
            subwayException.unexpected();
        }
    }
     // 등록하기
     public void sendRequest(Controller controller, String command){
         if(command.equals(Methods.등록.getCommand())){
             controller.register();
             return;
         }
         if(command.equals(Methods.삭제.getCommand())){
             controller.delete();
             return;
         }
         if(command.equals(Methods.조회.getCommand())){
             controller.read();
             return;
         }
         if(command.equals(Methods.돌아가기.getCommand())){
             return;
         }
         subwayException.notValidCommand();
     }
}
