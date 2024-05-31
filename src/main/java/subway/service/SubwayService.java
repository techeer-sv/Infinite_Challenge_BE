package subway.service;

import subway.domain.Station;

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

    public void deleteLine(String name) {
        lineService.deleteLine(name);
    }

    public void deleteStation(String name) {
        if (isStationInUse(name)) {
            throw new IllegalArgumentException("[ERROR] 노선에 등록된 역은 삭제할 수 없습니다.");
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
}
