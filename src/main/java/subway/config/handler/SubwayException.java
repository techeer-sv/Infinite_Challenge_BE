package subway.config.handler;

import subway.config.constants.views.Prefixes;

public class SubwayException extends IllegalArgumentException {
    public void notValidCommand() {
        throw new IllegalArgumentException(Prefixes.ERROR+"잘못된 명령입니다.");
    }

    public boolean isBack(String command){
        if(command.equals('B')){
            return true;
        }
        return false;
    }

    public void checkCommand() {
        throw new IllegalArgumentException(Prefixes.ERROR+ "입력값을 확인해주세요.");
    }

    public void noStation() {
        throw new IllegalArgumentException(Prefixes.ERROR+"존재하지 않는 역입니다.");
    }

    public void noLine() {
        throw new IllegalArgumentException(Prefixes.ERROR+"존재하지 않는 노선입니다.");
    }


}
