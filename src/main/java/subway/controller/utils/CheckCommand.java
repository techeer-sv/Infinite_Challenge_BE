package subway.controller.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static subway.controller.utils.ClassifyMethods.subwayException;

public class CheckCommand {
    private BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public boolean isQ(String node) {
        if (node.equals("Q") || node.equals("q")) {
            return true;
        }
        return false;
    }

    public boolean isMainCommand(String node, boolean isSection){
        if(isSection) return isSectionCommand(node);
        int command = strToInt(node);
        if(command == 0)
            return false;
        if(command < 0 || command > 4)
            return false;
        return true;
    }

    public boolean isSectionCommand(String node){
        int command = strToInt(node);
        if(command == 0)
            return false;
        if(command < 0 || command > 2)
            return false;
        return true;
    }

    public int strToInt(final String node) {
        if(node == null) return 0;
        try {
            return Integer.parseInt(node);
        } catch (NumberFormatException e) {
            subwayException.isNotUnder4OrQ();
        }
        return 0;
    }
}
