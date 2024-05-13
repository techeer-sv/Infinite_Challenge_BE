package subway.config.constants.views;

public enum Questions {
    FUNC("원하는 기능을 선택하세요.\n"),
    NAME("을 입력하세요.\n"),
    SEQUENCE("순서를 입력하세요.\n");

    private final String question;
    static final String SHARP = Prefixes.SHARP.getPrefix();

    Questions(String question) {
        this.question = question;
    }

    public String Message(){
        StringBuilder sb = new StringBuilder();
        sb.append(SHARP).append(this.question);
        return sb.toString();
    }

    public String Message(String target) {
        StringBuilder sb= new StringBuilder();
        sb.append(SHARP);
        sb.append(target).append(this.question);
        return sb.toString();
    }

    public String Message(String work, String target) {
        String message = work + "할 " + target + this.question;
        return message;
    }
}
