package subway.config.handler;

public class SubwayException extends IllegalArgumentException {
    public boolean isValidLength(String name) {
        if (name.length() >= 2) return true;
        throw new IllegalStateException("## 2글자 이상으로 입력해주세요.");
    }

    public void notValidCommand() {
        throw new IllegalArgumentException("## 잘못된 명령입니다.");
    }

    public void checkCommand() {
        throw new IllegalArgumentException("## 입력값을 확인해주세요.");
    }

    public void noStation() {
        throw new IllegalArgumentException("## 존재하지 않는 역입니다.");
    }

    public void noLine() {
        throw new IllegalArgumentException("## 존재하지 않는 노선입니다.");
    }


}
