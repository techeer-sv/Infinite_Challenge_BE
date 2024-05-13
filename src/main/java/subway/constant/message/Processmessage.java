package subway.constant.message;

public enum Processmessage {
    SUCCESS_PREFIX("[INFO] "),
    ;

    private final String message;

    Processmessage(final String message) {
        this.message = message;
    }

    public String toMessage() {
        return message;
    }
}
