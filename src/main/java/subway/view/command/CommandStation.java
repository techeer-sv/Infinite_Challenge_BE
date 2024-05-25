package subway.view.command;

import java.util.Arrays;

import subway.view.error.MainErrorMessage;

public enum CommandStation {
	ADD_STATION("1"),
	DELETE_STATION("2"),
	VIEW_STATIONS("3"),
	BACK("B");

	private final String command;

	CommandStation(String command) {
		this.command = command;
	}

	public static CommandStation fromString(final String number) {
		return Arrays.stream(CommandStation.values())
			.filter(e -> e.command.equals(number))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(MainErrorMessage.WRONG_NAME.getMessage()));
	}
}
