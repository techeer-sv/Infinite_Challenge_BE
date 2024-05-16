package subway.controller.utils;

import subway.config.handler.SubwayException;
import subway.service.Managerable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static subway.controller.utils.ClassifyMethods.subwayException;

public class Methods implements Constants {
    private BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
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
        try {
            String input = getUserInput();
            if (subwayException.isBack(input) == true) return -1;
            int index = Integer.parseInt(input);
            return index;
        } catch (SubwayException e) {
            e.isNotNumber();
        } catch (Exception e) {
            subwayException.checkCommand();
        }
        return -1;
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
        try {
            ask.orderWhere(function, target);
            return br.readLine();
        } catch (Exception e) {
            subwayException.checkCommand();
        }
        return null;
    }

    public String getStation() {
        ask.orderWhere("역 이름");

        try {
            return br.readLine();
        } catch (Exception e) {
            subwayException.noStation();
        }
        return null;
    }

    public String getStation(Managerable manager, String function, String station) {
        try {
            ask.orderWhere(function, station);
            String node = getUserInput();
            if (manager.isEmpty(node) != true) {
                subwayException.noStation();
            }
            return node;
        } catch (Exception e) {
            subwayException.unexpected();
        }
        return null;
    }
}
