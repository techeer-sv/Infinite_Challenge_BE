package subway.view.error;

public enum MainErrorMessage {

	WRONG_NAME("[ERROR] 존재하지 않는 번호입니다.");

	private String message;

	MainErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage(){
		return message;
	}
}
