package subway.view;

import java.util.List;

public class LineView {
	private static final String LINE = "## 노선 관리 화면";
	private static final String REGISTER_LINE = "1. 노선 등록";
	private static final String DELETE_LINE = "2. 노선 삭제";
	private static final String VIEW_LINES = "3. 노선 조회";
	private static final String BACK = "B. 돌아가기";
	private static final String ADD_LINE_NAME = "## 등록할 노선 이름을 입력하세요.";
	private static final String ADD_START_LINE_NAME = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
	private static final String ADD_END_LINE_NAME = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
	private static final String DELETE_LINE_NAME = "## 삭제할 노선 이름을 입력하세요.";
	private static final String SUCCESS_ADD_LINE = "[INFO] 지하철 노선이 등록되었습니다.";
	private static final String SUCCESS_DELETE_LINE = "[INFO] 지하철 노선이 삭제되었습니다.";
	private static final String SELECT_LINE = "## 노선 목록";

	public static void printLineView() {
		System.out.println(LINE + "\n" +
			REGISTER_LINE + "\n" +
			DELETE_LINE + "\n" +
			VIEW_LINES + "\n" +
			BACK);
	}

	public void printAddLine() {
		System.out.println(ADD_LINE_NAME);
	}

	public void printAddFirstLine() {
		System.out.println(ADD_START_LINE_NAME);
	}

	public void printAddLastLine() {
		System.out.println(ADD_END_LINE_NAME);
	}

	public void printSuccessAddLine() {
		System.out.println(SUCCESS_ADD_LINE);
	}

	public void printDeleteLine() {
		System.out.println(DELETE_LINE_NAME);
	}

	public void printSuccessDeleteLine() {System.out.println(SUCCESS_DELETE_LINE);}

	public void printSelectLine() {System.out.println(SELECT_LINE);}

	public void printLineList(List<String> lines) {
		lines.forEach(station -> System.out.println("[INFO] " + station));
	}


}
