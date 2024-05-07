package subway.constant;

import java.util.Arrays;
import subway.constant.message.ErrorMessage;

public enum MainCommand {
    STATION_MANAGE("1"),
    LINE_MANAGE("2"),
    SECTION_MANAGE("3"),
    PRINT_SUBWAY("4"),
    QUIT("Q");

    private final String command;

    MainCommand(final String command) {
        this.command = command;
    }

    public static MainCommand from(final String input) {
        return Arrays.stream(MainCommand.values())
                     .filter(e -> e.command.equalsIgnoreCase(input))
                     .findAny()
                     .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.ERROR_PREFIX.toMessage() + "없는 버튼입니다."));
    }
}
