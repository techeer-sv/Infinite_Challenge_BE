package subway.controller.utils;

import static subway.controller.utils.Constants.makeString;
import static subway.controller.utils.Constants.response;

public class SetPrint {

    public boolean printResult(String method, String target, boolean result){
        String message = makeString.infoMessage(method, target, result);
        response.printInfo(message);
        return true;
    }


}
