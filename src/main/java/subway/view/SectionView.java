package subway.view;

import java.util.List;

import subway.domain.Station;

public class SectionView {

	private static final String SECTION = "## 구간 관리 화면";
	private static final String ADD_SECTION = "1. 구간 등록";
	private static final String REMOVE_SECTION = "2. 구간 삭제";
	private static final String BACK = "B. 돌아가기";
	private static final String ADD_SECTION_NAME = "## 노선을 입력하세요.";
	private static final String ADD_STATION_NAME = "## 역이름을 입력하세요.";
	private static final String ADD_ORDER_NUMBER = "## 순서를 입력하세요.";
	private static final String DELETE_SECTION_NAME = "## 삭제할 구간의 노선을 입력하세요.";
	private static final String DELETE_STATION_NAME = "## 삭제할 구간의 역을 입력하세요.";
	private static final String SUCCESS_SECTION_STATION = "[INFO] 구간이 등록되었습니다.";
	private static final String SUCCESS_DELETE_SECTION = "[INFO] 구간이 삭제되었습니다.";

	public void printSectionView() {
		System.out.println(SECTION + "\n" +
			ADD_SECTION + "\n" +
			REMOVE_SECTION + "\n" +
			BACK);
	}

	public void printAddSection() {
		System.out.println(ADD_SECTION_NAME);
	}

	public void printAddStationName() {
		System.out.println(ADD_STATION_NAME);
	}

	public void printAddOrder() {
		System.out.println(ADD_ORDER_NUMBER);
	}

	public void printDeleteSection() {
		System.out.println(DELETE_SECTION_NAME);
	}

	public void printDeleteStation() {
		System.out.println(DELETE_STATION_NAME);
	}

	public void printSuccessSectionStation() {
		System.out.println(SUCCESS_SECTION_STATION);
	}

	public void printSuccessDeleteSection() {
		System.out.println(SUCCESS_DELETE_SECTION);
	}

}