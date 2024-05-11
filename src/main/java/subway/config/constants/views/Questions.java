package subway.config.constants.views;

public enum Questions {
    FUNC("원하는 기능을 선택하세요."),
    NAME("이름을 입력하세요."),
    SEQUENCE("순서를 입력하세요.");

    private final String questions;
    Questions(String questions){
        this.questions = questions;
    }
}
