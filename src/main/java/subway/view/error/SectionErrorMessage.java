package subway.view.error;

public enum SectionErrorMessage {
	NOT_LINE_EXISTS("[ERROR] 존재하지 않는 노선입니다."),
	NOT_STATION_EXISTS("[ERROR] 존재하지 않는 역입니다."),
	UN_REMOVABLE("[ERROR] 노선이 등록되어 있는 역입니다."),
	INSUFFICIENT_STATIONS("[ERROR] 노선에 포함된 역이 두 개 이하입니다.");

	private String message;

	SectionErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage(){
		return message;
	}
}
