package subway.view.command;

import java.util.Arrays;

import subway.view.error.MainErrorMessage;

public enum CommandMain {
	MANAGE_STATION("1"),
	MANAGE_LINE("2"),
	MANAGE_SECTION("3"),
	PRINT_LINE_MAP("4"),
	QUIT("Q");

	private final String command;

	CommandMain(String command) {
		this.command = command;
	}

	public static CommandMain fromString(final String number) {
		return Arrays.stream(CommandMain.values())
			.filter(e -> e.command.equals(number))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(MainErrorMessage.WRONG_NAME.getMessage()));
	}


}
