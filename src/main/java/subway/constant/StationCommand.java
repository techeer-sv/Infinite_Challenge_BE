package subway.constant;

import java.util.Arrays;
import subway.constant.message.ErrorMessage;

public enum StationCommand {
    SAVE("1"),
    DELETE("2"),
    SELECT("3"),
    BACK("B");

    private final String command;

    StationCommand(final String command) {
        this.command = command;
    }

    public static StationCommand from(final String input) {
        return Arrays.stream(StationCommand.values())
                     .filter(e -> e.command.equals(input))
                     .findAny()
                     .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.ERROR_PREFIX.toMessage() + "없는 버튼입니다."));
    }
}
