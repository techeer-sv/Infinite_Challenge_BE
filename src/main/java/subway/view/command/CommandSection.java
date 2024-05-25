package subway.view.command;

import java.util.Arrays;

import subway.view.error.MainErrorMessage;

public enum CommandSection {
	ADD_SECTION("1"),
	DELETE_SECTION("2"),
	BACK("B");

	private final String command;

	CommandSection(String command) {
		this.command = command;
	}

	public static CommandSection fromString(final String number) {
		return Arrays.stream(CommandSection.values())
			.filter(e -> e.command.equals(number))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(MainErrorMessage.WRONG_NAME.getMessage()));
	}
}
