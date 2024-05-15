package subway.config.constants.views;

public enum Targets {
    STATION("역", 1),
    LINE("노선",2),
    SECTION("구간", 3),
    MAP("지하철 노선도", 4),
    UPPER("상행 종점역", 5),
    BOTTOM("하행 종점역", 6);

    private final String target;
    private final int command;
    Targets(String target, int command){
        this.target = target;
        this.command=command;
    }

    public String getTarget(){
        return this.target;
    }

    public int getCommand(){
        return this.command;
    }
}
