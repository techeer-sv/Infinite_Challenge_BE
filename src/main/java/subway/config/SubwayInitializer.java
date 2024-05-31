package subway.config;

import subway.domain.enums.LineEnum;
import subway.domain.enums.StationEnum;
import subway.service.SubwayService;

public class SubwayInitializer {
    private final SubwayService subwayService;

    public SubwayInitializer(SubwayService subwayService) {
        this.subwayService = subwayService;
    }

    public void initialize() {
        initializeStations();
        initializeLines();
    }

    private void initializeStations() {
        for (StationEnum station : StationEnum.values()) {
            subwayService.addStation(station.getName());
        }
    }

    private void initializeLines() {
        for (LineEnum line : LineEnum.values()) {
            subwayService.addLine(line.getName(), line.getStations());
        }
    }

}
