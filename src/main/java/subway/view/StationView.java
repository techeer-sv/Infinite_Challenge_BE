package subway.view;

import java.util.List;

public class StationView {
	private static final String STATION = "## 역 관리 화면";
	private static final String ADD_STATION = "1. 역 등록";
	private static final String DELETE_STATION = "2. 역 삭제";
	private static final String VIEW_STATIONS = "3. 역 조회";
	private static final String BACK = "B. 돌아가기";
	private static final String ADD_STATION_NAME = "## 등록할 역 이름을 입력하세요.";
	private static final String DELETE_STATION_NAME = "## 삭제할 역 이름을 입력하세요.";
	private static final String SUCCESS_ADD_STATION = "[INFO] 지하철 역이 등록되었습니다.";
	private static final String SUCCESS_DELETE_STATION = "[INFO] 지하철 역이 삭제되었습니다.";
	private static final String SELECT_STATION = "## 역 목록";



	public void printStationView() {
		System.out.println(STATION + "\n" +
			ADD_STATION + "\n" +
			DELETE_STATION + "\n" +
			VIEW_STATIONS + "\n" +
			BACK);
	}

	public void printAddStation() {
		System.out.println(ADD_STATION_NAME);
	}

	public void printSuccessAddStation() {
		System.out.println(SUCCESS_ADD_STATION);
	}

	public void printDeleteStation() {
		System.out.println(DELETE_STATION_NAME);
	}

	public void printSuccessDeleteStation() {System.out.println(SUCCESS_DELETE_STATION);}

	public void printSelectStation() {System.out.println(SELECT_STATION);}

	public void printStationList(List<String> stations) {
		stations.forEach(station -> System.out.println("[INFO] " + station));
	}

}
