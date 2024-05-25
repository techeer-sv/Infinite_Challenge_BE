package subway.view.error;

public enum LineErrorMessage {
	ALREADY_EXISTS("[ERROR] 이미 존재하는 노선 이름입니다."),
	NOT_EXISTS("[ERROR] 존재하지 않는 노선입니다."),
	WRONG_NAME("[ERROR] 노선 이름은 2글자 이상이어야 합니다."),
	STATION_NAME_REQUIRED("[ERROR] 상행 종점역과 하행 종점역 이름 입력은 필수입니다.");

	private final String message;

	LineErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
