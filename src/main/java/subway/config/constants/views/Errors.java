package subway.config.constants.views;

public enum Errors {
    VALID("선택할 수 없는 기능입니다."),
    ADD_STATION("이미 등록된 역 이름입니다."),
    ADD_LINE("이미 등록된 노선 이름입니다."),
    DEL_STATION("존재하지 않은 역 이름입니다."),
    DEL_LINE("존재하지 않는 노선 이름입니다.");

    private final String message;
    Errors(String message){
        this.message = message;
    }
}
