package subway.config.constants.views;

public enum Titles {
    MAIN("메인 화면"),
    STATION("역 관리 화면"),
    STATIONS("역 목록"),
    LINE("노선 관리 화면"),
    LINES("노선 목록"),
    SECTION("구간 관리 화면"),
    SECTIONS("구간 목록"),
    MAP("지하철 노선도");

    private String title;
    Titles(String title){
        this.title=title;
    }
}
