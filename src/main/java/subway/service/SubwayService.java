package subway.service;

import subway.domain.Line;
import subway.domain.Station;
import subway.global.error.ErrorMessage;

import java.util.List;

public class SubwayService {

    private final StationService stationService;
    private final LineService lineService;

    public SubwayService(StationService stationService, LineService lineService) {
        this.stationService = stationService;
        this.lineService = lineService;
    }

    public void addStation(String name) {
        stationService.addStation(name);
    }

    public void addLine(String name, String[] stationNames) {
        lineService.addLine(name, stationNames);
    }

    public void addLine(String name, String upStationName, String downStationName) {
        lineService.addLine(name, upStationName, downStationName);
    }

    public void addSection(String lineName, String stationName, String upStationName, String downStationName) {
        lineService.addSection(lineName, stationName, upStationName, downStationName);
    }

    public void deleteLine(String name) {
        lineService.deleteLine(name);
    }

    public void deleteStation(String name) {
        if (isStationInUse(name)) {
            throw new IllegalArgumentException(ErrorMessage.STATION_IN_USE);
        }
        stationService.deleteStation(name);
    }

    private boolean isStationInUse(String name) {
        return lineService.getLines().stream()
                .flatMap(line -> line.getStations().stream())
                .anyMatch(station -> station.getName().equals(name));
    }

    public List<Station> getStations() {
        return stationService.getStations();
    }

    public List<Line> getLines() {
        return lineService.getLines();
    }
}
