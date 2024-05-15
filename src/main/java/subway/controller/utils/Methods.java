package subway.controller.utils;

import subway.service.Managerable;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static subway.service.utils.Constants.subwayException;

public class Methods implements Constants{
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public Methods(){}
    public int getIndex() { // numberformat error 추가
        ask.orderWhere();
        try {
            String input = br.readLine();
            if(subwayException.isBack(input) == true) return -1;
            int index = Integer.parseInt(input);
            return index;
        } catch (Exception e) {
            subwayException.checkCommand();
        }
        return -1;
    }

    public String getLine() {
        ask.orderWhere(LINE);
        try {
            String line = br.readLine();
            return line;
        } catch (Exception e) {
            e.printStackTrace();
            subwayException.unexpected();
        }
        return null;
    }

    public String getLine(String function, String target){
        try {
            ask.orderWhere(function, target);
            return br.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getStation() {
        ask.orderWhere("역 이름");
        try {
            return br.readLine();
        } catch (Exception e) {
            subwayException.unexpected();
        }
        return null;
    }

    public String getStation(Managerable manager, String function, String station) {
        try {
            ask.orderWhere(function, station);
            String node = br.readLine();
            if(manager.isValid(node)!= true){ // 에러 커스텀
                System.err.println("[ERROR] 존재하지 않는 역입니다.");
                return null;
            }
            return node;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
