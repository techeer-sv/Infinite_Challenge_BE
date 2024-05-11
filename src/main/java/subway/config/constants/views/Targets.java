package subway.config.constants.views;

public enum Targets {
    LINE("노선"),
    STATION("역"),
    SECTION("구간"),
    MAP("지하철 노선도"),
    UPPER("상행 종점역"),
    BOTTOM("하행 종점역");

    private final String target;
    Targets(String target){
        this.target = target;
    }

    public String getTarget(){
        return this.target;
    }
}
