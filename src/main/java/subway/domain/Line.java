package subway.domain;

public class Line {
    private String name;
    private Station upperStation;
    private Station bottomStation;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStations(Station upper, Station bottom){
        this.upperStation = upper;
        this.bottomStation=bottom;
    }

    // 추가 기능 구현
}
