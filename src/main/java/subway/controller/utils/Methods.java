package subway.controller.utils;

import subway.config.constants.Targets;
import subway.config.handler.InputException;
import subway.service.utils.Managerable;
import subway.service.utils.Verify;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static subway.controller.utils.ClassifyMethods.checkCommand;
import static subway.controller.utils.ClassifyMethods.subwayException;

public class Methods extends Verify implements Constants {
    private BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    InputException inputException = new InputException();
    public Methods() {}

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
        ask.orderWhere();
        String input = getUserInput();
        if (subwayException.isBack(input) == true) return -1;
        int index = checkCommand.strToInt(input);
        if(index <= 0) subwayException.checkCommand();
        return index;
    }

    public String getLine() {
        ask.orderWhere(LINE);
        try {
            String line = getUserInput();
            return line;
        } catch (Exception e) {
            subwayException.checkCommand();
        }
        return null;
    }

    public String getLine(String function, String target) {
        ask.orderWhere(function, target);
        return getUserInput();
    }

    public String getStation() {
        ask.orderWhere("역 이름");
        return getUserInput();
    }

    public String getStation(Managerable manager, String function, String station) {
        ask.orderWhere(function, station);
        String node = getUserInput();
        if (manager.isEmpty(Targets.STATION.getTarget(),node) == true) {
            subwayException.noStation();
        }
        return node;
    }
}
