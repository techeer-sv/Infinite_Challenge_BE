package subway.controller;

import subway.view.AskView;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StationController {
    AskView ask = new AskView();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void askQuestion(){
        ask.Function();
        try{
            String command = br.readLine();
            // command 내용 확인하고 맞는 처리와 연결
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public int registerControll() throws Exception{
        ask.Name("등록", "역");
        String station = br.readLine();
        register(station);
        // "지하철 역이 등록되었습니다." 출력
        return Integer.parseInt(br.readLine());
    }

    public void register(String station){
        // db 접근해서 데이터 삽입하는 서비스와 연결
    }

    public void requestStations() throws Exception{
        // 역 목록을 출력하는 서비스 코
    }
}
