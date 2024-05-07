package subway.constant;

import java.util.Arrays;
import subway.constant.message.ErrorMessage;

public enum LineCommand {

    SAVE("1"),
    DELETE("2"),
    SELECT("3"),
    BACK("B");

    private final String command;

    LineCommand(final String command) {
        this.command = command;
    }

    public static LineCommand from(final String input) {
        return Arrays.stream(LineCommand.values())
                     .filter(e -> e.command.equals(input))
                     .findAny()
                     .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.ERROR_PREFIX.toMessage() + "없는 버튼입니다."));
    }
}
