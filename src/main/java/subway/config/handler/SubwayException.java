package subway.config.handler;

import subway.config.constants.views.Errors;
import subway.config.constants.views.Prefixes;

import static subway.config.handler.InputExceptionError.ErrorMessage.*;

public class SubwayException extends RuntimeException {
    private static String ERROR = Prefixes.ERROR.getPrefix();

    public boolean isNotNumber(){
        throw new NumberFormatException(PUT_ONLY_VAILD_NUMBER.getMessage());
    }

    public boolean isNotUnder4OrQ(){
        throw new IllegalArgumentException(PUT_UNDER_4_OR_Q_VALUE.getMessage());
    }

    public void notValidCommand() {
        throw new IllegalArgumentException(PUT_VAILD_VALUE.getMessage());
    }



    public void unexpected(){
        throw new IllegalArgumentException(ERROR+Errors.UNEXPECTED.getError());
    }
    public boolean isBack(String command){
        if(command.equals("B")){
            return true;
        }
        return false;
    }

    public void checkCommand() {
        throw new IllegalArgumentException(ERROR+ Errors.VALID.getError());
    }

    public boolean alreadyCreatedLine(){
        throw new IllegalArgumentException(THERE_IS_AREADY_THE_SAME_LINE.getMessage());
    }
    public boolean alreadyCreatedStation(){
        throw new IllegalArgumentException(THERE_IS_AREADY_THE_SAME_STATION.getMessage());
    }

    public boolean noStation() {
        throw new IllegalArgumentException(THERE_IS_NO_SUCH_STATION.getMessage());
    }

    public void noLine() {
        throw new IllegalArgumentException(THERE_IS_NO_SUCH_LINE.getMessage());
    }
    public void underTwoStation() {
        throw new IllegalArgumentException();
    }
}
