package subway.controller.utils;

import subway.service.utils.Managerable;
import subway.service.utils.Verify;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static subway.controller.utils.ClassifyMethods.checkCommand;
import static subway.controller.utils.ClassifyMethods.subwayException;

public class GetUserInput extends Verify implements Constants {
    private BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public GetUserInput() {}

    public void closeBuffer(){
        try{
            br.close();
        }catch (IOException e){
            System.err.println("[ERROR] BufferedReader를 닫는 중 에러가 발생했습니다.");
        }
    }

    public String getUserInput(){
        try{
            return br.readLine();
        }catch (IOException e){
            System.err.println("[ERROR] 사용자 입력을 받는 중 에러가 발생했습니다.");
        }
        return null;
    }

    public int getIndex() {
        ask.orderIndex();
        String input = getUserInput();
        if (subwayException.isBack(input) == true) return -1;
        int index = checkCommand.strToInt(input);
        if(index <= 0) subwayException.checkCommand();
        return index;
    }

    public String getLine() {
        ask.orderIndex(LINE);
        try {
            return getUserInput();
        } catch (Exception e) {
            subwayException.checkCommand();
        }
        return null;
    }

    public String getLine(String function, String target) {
        ask.orderIndex(function, target);
        return getUserInput();
    }

    public String getStation() {
        ask.orderIndex("역 이름");
        return getUserInput();
    }

    public String getStation(Managerable manager, String function, String station) {
        ask.orderIndex(function, station);
        String node = getUserInput();
        if (manager.isEmpty(STATION,node) == true) {
            subwayException.noStation();
        }
        return node;
    }
}
