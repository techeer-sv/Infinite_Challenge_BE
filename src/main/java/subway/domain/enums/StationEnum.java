package subway.domain.enums;

public enum StationEnum {
    GYO_DAE("교대역"),
    GANG_NAM("강남역"),
    YEOK_SAM("역삼역"),
    NAM_BU_TERMINAL("남부터미널역"),
    YANG_JAE("양재역"),
    YANG_JAE_CITIZENS_FOREST("양재시민의숲역"),
    MAE_BONG("매봉역");

    private final String name;

    StationEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
