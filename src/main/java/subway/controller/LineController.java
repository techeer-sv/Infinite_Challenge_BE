package subway.controller;

import subway.view.AskView;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LineController {
    AskView ask = new AskView();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public LineController(){}
    public void work(){
        ask.Function();
        try{
            String command = br.readLine();
            // command 내용 확인하고 맞는 처리와 연결
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
