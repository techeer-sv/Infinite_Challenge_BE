package subway.view.error;

public enum StationErrorMessage {
	ALREADY_EXISTS("[ERROR] 중복된 이름입니다."),
	NOT_EXISTS("[ERROR] 존재하지 않는 역입니다."),
	UN_REMOVABLE("[ERROR] 노선이 등록되어 있는 역입니다."),
	WRONG_NAME("[ERROR] 지하철 역 이름은 2글자 이상이어야 합니다.");

	private String message;

	StationErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage(){
		return message;
	}
}
