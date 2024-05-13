package subway.constant;

import java.util.Arrays;
import subway.constant.message.ErrorMessage;

public enum SectionCommand {
    SAVE("1"),
    DELETE("2"),
    BACK("B");

    private final String command;

    SectionCommand(final String command) {
        this.command = command;
    }

    public static SectionCommand from(final String input) {
        return Arrays.stream(SectionCommand.values())
                     .filter(e -> e.command.equals(input))
                     .findAny()
                     .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.ERROR_PREFIX.toMessage() + "없는 버튼입니다."));
    }
}
