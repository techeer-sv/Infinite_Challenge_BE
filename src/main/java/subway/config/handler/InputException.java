package subway.config.handler;

import static subway.config.constants.views.Errors.*;

public class InputException {
    public void noStation(){
        System.err.println(DEL_STATION.getError());
    }

    public void alreadyCreatedLine(){
        System.err.println(ADD_LINE.getError());
    }

    public void alreadyCreatedStation(){
        System.err.println(ADD_STATION.getError());
    }

    public void noCreatedLine(){
        System.err.println(DEL_LINE.getError());
    }

    public void unExpectedError(){
        System.err.println(UNEXPECTED.getError());
    }


    public void underTwoStation() {
        System.err.println(UNDER_TWO_STATIONS.getError());
    }

    public void lineEqualStation(){
        System.err.println(ADD_STATION.getError());
    }

    public void alreadyWithStation() {
        System.err.print(ALREADY_WITH_STAION.getError());
    }

    public void haveLines() {
        System.err.println(STATIONS_UNDER_LINE.getError());
    }

    public void noSuchLine() {
        System.err.println(NO_SUCH_LINE.getError());
    }
}
