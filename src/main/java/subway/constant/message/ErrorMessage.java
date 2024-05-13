package subway.constant.message;

public enum ErrorMessage {
    ERROR_PREFIX("[ERROR] ");

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String toMessage() {
        return message;
    }
}
