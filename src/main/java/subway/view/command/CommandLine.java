package subway.view.command;

import java.util.Arrays;

import subway.view.error.MainErrorMessage;

public enum CommandLine {
	ADD_LINE("1"),
	REMOVE_LINE("2"),
	VIEW_LINES("3"),
	BACK("B");

	private final String command;

	CommandLine(String command) {
		this.command = command;
	}

	public static CommandLine fromString(final String number) {
		return Arrays.stream(CommandLine.values())
			.filter(e -> e.command.equals(number))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(MainErrorMessage.WRONG_NAME.getMessage()));
	}
}
