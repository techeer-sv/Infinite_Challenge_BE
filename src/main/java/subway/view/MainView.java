package subway.view;

public class MainView {
	private static final String MAIN = "## 메인 화면";
	private static final String STATION_MANAGEMENT = "1. 역 관리";
	private static final String LINE_MANAGEMENT = "2. 노선 관리";
	private static final String SECTION_MANAGEMENT = "3. 구간 관리";
	private static final String MAP_DISPLAY = "4. 지하철 노선도 출력";
	private static final String EXIT = "Q. 종료";
	private static final String SELECT_VIEW = "## 원하는 기능을 선택하세요.";



	public void printMainView() {
		System.out.println(MAIN + "\n" +
			STATION_MANAGEMENT + "\n" +
			LINE_MANAGEMENT + "\n" +
			SECTION_MANAGEMENT + "\n" +
			MAP_DISPLAY + "\n" +
			EXIT);
	}

	public void printSelectView() {
		System.out.println(SELECT_VIEW);
	}




}

