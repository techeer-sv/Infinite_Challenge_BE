package subway.config.handler;

import subway.config.constants.views.Errors;
import subway.config.constants.views.Prefixes;

public class SubwayException extends IllegalArgumentException {
    private static String ERROR = Prefixes.ERROR.getPrefix();
    public void notValidCommand() {
        throw new IllegalArgumentException(ERROR+ Errors.VALID.getError());
    }
    public void areadyCreated(){
        throw new IllegalArgumentException(ERROR+Errors.ADD_LINE.getError());
    }


    public void unexpected(){
        throw new IllegalArgumentException(ERROR+Errors.UNEXPECTED.getError());
    }
    public boolean isBack(String command){
        if(command.equals('B')){
            return true;
        }
        return false;
    }

    public void checkCommand() {
        throw new IllegalArgumentException(ERROR+ Errors.VALID.getError());
    }

    public void noStation() {
        throw new IllegalArgumentException(ERROR+Errors.DEL_STATION.getError());
    }

    public void noLine() {
        throw new IllegalArgumentException(ERROR+Errors.DEL_LINE.getError());
    }


}
