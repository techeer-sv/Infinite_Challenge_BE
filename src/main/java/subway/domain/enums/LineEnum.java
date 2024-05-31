package subway.domain.enums;

public enum LineEnum {

    LINE_2("2호선", new String[]{"교대역", "강남역", "역삼역"}),
    LINE_3("3호선", new String[]{"교대역", "남부터미널역", "양재역", "매봉역"}),
    SIN_BUNDANG("신분당선", new String[]{"강남역", "양재역", "양재시민의숲역"});

    private final String name;
    private final String[] stations;

    LineEnum(String name, String[] stations) {
        this.name = name;
        this.stations = stations;
    }

    public String getName() {
        return name;
    }

    public String[] getStations() {
        return stations;
    }
}
