package subway.controller.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static subway.service.utils.Constants.subwayException;

public class CheckCommand {
    public boolean isQ(String node) {
        if (node.equals("Q") || node.equals("q")) {
            return true;
        }
        return false;
    }

    public boolean isMainCommand(String node){
        int command = strToInt(node);
        if(command == 0)
            return false;
        if(command < 0 || command > 4)
            return false;
        return true;
    }

    public int strToInt(final String node) {
        try {
            return Integer.parseInt(node);
        } catch (NumberFormatException e) {
            subwayException.isNotUnder4OrQ();
        }
        return 0;
    }

    public String getCommand(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            String command = br.readLine();
            return command;
        }catch (IOException e){
            System.err.println("입력 오류 발생");
            return null;
        }
    }
}
