package subway.global.error;

public class ErrorMessage {
    public static final String DUPLICATE_LINE = "[ERROR] 중복된 노선 이름입니다.";
    public static final String LINE_TOO_SHORT = "[ERROR] 노선 이름은 2글자 이상이어야 합니다.";
    public static final String STATION_TOO_SHORT = "[ERROR] 역 이름은 2글자 이상이어야 합니다.";
    public static final String SECTION_NOT_FOUND = "[ERROR] 구간을 찾을 수 없습니다.";
    public static final String STATION_NOT_FOUND = "[ERROR] 존재하지 않는 역입니다.";
    public static final String UP_STATION_NOT_FOUND = "[ERROR] 존재하지 않는 상행 종점역입니다.";
    public static final String DOWN_STATION_NOT_FOUND = "[ERROR] 존재하지 않는 하행 종점역입니다.";
    public static final String STATION_IN_USE = "[ERROR] 노선에 등록된 역은 삭제할 수 없습니다.";
    public static final String LINE_NOT_FOUND = "[ERROR] 존재하지 않는 노선입니다.";
    public static final String DUPLICATE_STATION = "[ERROR] 중복된 역 이름입니다.";
}
