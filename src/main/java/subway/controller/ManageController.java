package subway.controller;

import subway.view.AskView;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public abstract class ManageController {
    AskView ask = new AskView();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void work(){
//        ask.Function();
        // 관련 컨트롤러 호출 부분
    }

    public abstract void registerControll() ;
        // 등록하기

    public abstract void register(String station);
        // db 접근해서 데이터 삽입하는 서비스와 연결

    public abstract void delete(String station);
        // db 접근해서 데이터 삭제하는 서비스와 연결

    // 되돌아가기
    public void goBack(){
        return;
    }
}
