package subway.config.constants.views;

public enum Questions {
    FUNC("원하는 기능을 선택하세요."),
    NAME("이름을 입력하세요."),
    SEQUENCE("## 순서를 입력하세요.\n");

    private final String question;

    Questions(String question) {
        this.question = question;
    }

    public String Message(String m, String t) {
        String message = m + "할 " + t + this.question + "\n";
        return message;
    }

    public String Message() {
        return this.question;
    }
}
