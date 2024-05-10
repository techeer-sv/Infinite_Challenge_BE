package subway.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import subway.constant.message.ErrorMessage;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.Subway;

public class SubwayService {

    private static final int LIMIT_SUBWAY_STATION_SIZE = 2;
    private final Subway subway = new Subway();
    private final LineRepository lineRepository = new LineRepository();
    private final StationRepository stationRepository = new StationRepository();

    public void saveStation(final String input) {
        final Station station = new Station(input);
        stationRepository.save(station);
    }

    public void deleteStation(final String input) {
        stationRepository.delete(input);
    }


    public void saveAllStations(final List<String> inputs) {
        List<Station> stations = inputs.stream()
                                       .map(Station::new)
                                       .collect(Collectors.toList());
        stations.forEach(stationRepository::save);
    }

    public void saveAllLines(final List<String> inputs) {
        List<Line> lines = inputs.stream()
                                 .map(Line::new)
                                 .collect(Collectors.toList());
        lines.forEach(lineRepository::save);
    }

    public void saveAllSubway(final Map<String, List<String>> subwayMaps) {
        for (Map.Entry<String, List<String>> entry : subwayMaps.entrySet()) {
            Line line = new Line(entry.getKey());
            List<Station> stations = entry.getValue().stream()
                                          .map(Station::new)
                                          .collect(Collectors.toList());
            subway.getSubway().put(line, stations);
        }
    }

    public void initializeSubway() {
        List<String> stations = List.of("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
        saveAllStations(stations);
        List<String> lines = List.of("2호선", "3호선", "신분당선");
        saveAllLines(lines);
        Map<String, List<String>> map = new HashMap<>();
        map.put("2호선", List.of("교대역", "강남역", "역삼역"));
        map.put("3호선", List.of("교대역", "남부터미널역", "양재역", "매봉역"));
        map.put("신분당선", List.of("강남역", "양재역", "양재시민의숲역"));
        saveAllSubway(map);
    }

    public List<String> getAllStations() {
        return stationRepository.getAll().stream()
                                .map(Station::getName)
                                .collect(Collectors.toList());
    }

    public void saveLine(final String lineName, final String startStationName, final String endStationName) {
        final Station startStation = stationRepository.getByName(startStationName);
        final Station endStation = stationRepository.getByName(endStationName);
        final Line line = lineRepository.getByName(lineName);
        subway.addNewSubwayLine(line, List.of(startStation, endStation));
    }

    public void deleteLine(final String lineName) {
        lineRepository.delete(lineName);
    }

    public List<String> getAllLine() {
        return lineRepository.getAll().stream()
                             .map(Line::getName)
                             .collect(Collectors.toList());
    }

    public void addSubwayStation(final String inputLine, final String inputStation, final String inputIndex) {
        final Line line = lineRepository.getByName(inputLine);
        final Station station = stationRepository.getByName(inputStation);
        final int stationIndex = Integer.parseInt(inputIndex);
        subway.addStationByLine(line, station, stationIndex);
    }

    public void deleteSubwayLine(final String inputLine) {
        final Line line = lineRepository.getByName(inputLine);
        if (subway.getStationSize(line) <= LIMIT_SUBWAY_STATION_SIZE) {
            throw new IllegalStateException(ErrorMessage.ERROR_PREFIX.toMessage() + "역이 2개 이하면 삭제할 수 없습니다.");
        }
        subway.deleteSubwayByLine(line);
    }

    public Subway getSubway() {
        return subway;
    }
}

