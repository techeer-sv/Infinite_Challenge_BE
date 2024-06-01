package subway.service;

import subway.domain.Line;
import subway.domain.repository.LineRepository;
import subway.domain.Station;
import subway.domain.repository.StationRepository;
import subway.global.error.ErrorMessage;

import java.util.List;

public class LineService {

    private final LineRepository lineRepository;
    private final StationRepository stationRepository;
    private final StationService stationService;

    public LineService(LineRepository lineRepository, StationRepository stationRepository,
                       StationService stationService) {
        this.lineRepository = lineRepository;
        this.stationRepository = stationRepository;
        this.stationService = stationService;
    }

    public void addLine(String name, String[] stationNames) {
        Line line = new Line(name);
        for (String stationName : stationNames) {
            Station station = stationService.findStationByName(stationName, ErrorMessage.STATION_NOT_FOUND);
            line.addStation(station);
        }
        lineRepository.addLine(line);
    }

    public void addLine(String name, String upStationName, String downStationName) {
        Station upStation = stationService.findStationByName(upStationName, ErrorMessage.UP_STATION_NOT_FOUND);
        Station downStation = stationService.findStationByName(downStationName, ErrorMessage.DOWN_STATION_NOT_FOUND);
        Line line = new Line(name, upStation, downStation);
        lineRepository.addLine(line);
    }

    public void addSection(String lineName, String stationName, String upStationName, String downStationName) {
        Line line = findLineByName(lineName, ErrorMessage.LINE_NOT_FOUND);
        Station station = stationService.findStationByName(stationName, ErrorMessage.STATION_NOT_FOUND);
        Station upStation = stationService.findStationByName(upStationName, ErrorMessage.UP_STATION_NOT_FOUND);
        Station downStation = stationService.findStationByName(downStationName, ErrorMessage.DOWN_STATION_NOT_FOUND);
        line.addSection(station, upStation, downStation);
    }

    public void deleteLine(String name) {
        if (!lineRepository.deleteLineByName(name)) {
            throw new IllegalArgumentException(ErrorMessage.DOWN_STATION_NOT_FOUND);
        }
    }

    public List<Line> getLines() {
        return lineRepository.lines();
    }

    private Line findLineByName(String name, String errorMessage) {
        return lineRepository.lines().stream()
                .filter(l -> l.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(errorMessage));
    }
}
