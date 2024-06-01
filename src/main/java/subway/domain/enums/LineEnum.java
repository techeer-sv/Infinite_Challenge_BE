package subway.domain.enums;

import java.util.Arrays;

public enum LineEnum {

    LINE_2("2호선", new StationEnum[]{StationEnum.GYO_DAE, StationEnum.GANG_NAM, StationEnum.YEOK_SAM}),
    LINE_3("3호선", new StationEnum[]{StationEnum.GYO_DAE, StationEnum.NAM_BU_TERMINAL, StationEnum.YANG_JAE, StationEnum.MAE_BONG}),
    LINE_SIN_BUNDANG("신분당선", new StationEnum[]{StationEnum.GANG_NAM, StationEnum.YANG_JAE, StationEnum.YANG_JAE_CITIZENS_FOREST});


    private final String name;
    private final StationEnum[] stations;

    LineEnum(String name, StationEnum[] stations) {
        this.name = name;
        this.stations = stations;
    }

    public String getName() {
        return name;
    }

    public String[] getStations() {
        return Arrays.stream(stations)
                .map(StationEnum::getName)
                .toArray(String[]::new);
    }
}
