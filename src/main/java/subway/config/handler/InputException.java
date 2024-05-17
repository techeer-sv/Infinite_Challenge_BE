package subway.config.handler;

import static subway.config.constants.views.Errors.*;
import static subway.config.constants.views.Prefixes.ERROR;

public class InputException {
    public void noStation(){
        StringBuilder sb = new StringBuilder();
        sb.append(DEL_STATION.getError());
        System.err.println(sb);
    }

    public void alreadyCreatedLine(){
        StringBuilder sb = new StringBuilder();
        sb.append(ADD_LINE.getError());
        System.err.println(sb);
    }

    public void alreadyCreatedStation(){
        StringBuilder sb = new StringBuilder();
        sb.append(ADD_STATION.getError());
        System.err.println(sb);
    }

    public void noCreatedLine(){
        StringBuilder sb = new StringBuilder();
        sb.append(DEL_LINE.getError());
        System.err.println(sb);
    }

    public void unExpectedError(){
        StringBuilder sb = new StringBuilder();
        sb.append(UNEXPECTED.getError());
        System.err.println(sb);
    }


    public void underTwoStation() {
        StringBuilder sb = new StringBuilder();
        sb.append(UNDER_TWO_STATIONS.getError());
        System.err.println(sb);
    }
}
