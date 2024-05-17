package subway.config.handler;

import static subway.config.constants.views.Errors.ADD_LINE;
import static subway.config.constants.views.Errors.DEL_STATION;
import static subway.config.constants.views.Prefixes.ERROR;

public class InputException {
    public void noStation(){
        StringBuilder sb = new StringBuilder();
        sb.append(DEL_STATION.getError());
        System.out.println(sb);
    }

    public void alreadyCreatedLine(){
        StringBuilder sb = new StringBuilder();
        sb.append(ADD_LINE.getError());
        System.out.println(sb);
    }
}
