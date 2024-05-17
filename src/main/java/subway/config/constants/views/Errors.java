package subway.config.constants.views;

public enum Errors {
    VALID("잘못된 명령입니다. 입력값을 확인해주세요."),
    ADD_STATION("이미 등록된 역 이름입니다."),
    ADD_LINE("이미 등록된 노선 이름입니다."),
    ADDED("이미 등록된 이름입니다."),
    DEL_STATION("존재하지 않은 역 이름입니다."),
    UNEXPECTED("예상치 못한 에러가 발생했습니다."),
    UNDER_TWO_STATIONS("속한 역의 개수가 2개 이하인 노선은 삭제할 수 없습니다."),
    DEL_LINE("존재하지 않는 노선 이름입니다.");

    private final String message;
    Errors(String message){
        this.message = message;
    }
    public String getError(){
        return this.message;
    }
}
