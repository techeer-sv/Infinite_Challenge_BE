package subway.service;

import java.util.List;
import java.util.stream.Collectors;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Section;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.error.LineErrorMessage;
import subway.view.error.StationErrorMessage;

public class LineService {

	private final LineRepository lineRepository;
	private final SectionRepository sectionRepository;
	private final StationRepository stationRepository;

	public LineService() {
		this.lineRepository = new LineRepository();
		this.sectionRepository = new SectionRepository();
		this.stationRepository = new StationRepository();
	}

	public void addLine(String lineName, String startStationName, String endStationName) {
		validateLineName(lineName);
		validateStations(startStationName, endStationName);

		lineRepository.findLineByName(lineName).ifPresent(line -> {
			throw new IllegalArgumentException(LineErrorMessage.ALREADY_EXISTS.getMessage());
		});

		Station startStation = stationRepository.findStationByName(startStationName)
			.orElseThrow(() -> new IllegalArgumentException(StationErrorMessage.NOT_EXISTS.getMessage()));
		Station endStation = stationRepository.findStationByName(endStationName)
			.orElseThrow(() -> new IllegalArgumentException(StationErrorMessage.NOT_EXISTS.getMessage()));

		Line newLine = new Line(lineName);
		lineRepository.addLine(newLine);

		Section section = new Section(newLine);
		section.addStation(startStation);
		section.addStation(endStation);
		sectionRepository.addSection(section);
	}


	private void validateLineName(String lineName) {
		if (lineName.length() < 2) {
			throw new IllegalArgumentException(LineErrorMessage.WRONG_NAME.getMessage());
		}
	}

	private void validateStations(String startStation, String endStation) {
		if (startStation.isEmpty() || endStation.isEmpty()) {
			throw new IllegalArgumentException(LineErrorMessage.STATION_NAME_REQUIRED.getMessage());
		}
	}

	public void deleteLine(String lineName) {
		if (!lineRepository.deleteLineByName(lineName)) {
			throw new IllegalArgumentException(LineErrorMessage.NOT_EXISTS.getMessage());
		}
	}

	public List<String> getLines() {
		return lineRepository.lines().stream()
			.map(Line::getName)
			.collect(Collectors.toList());
	}

}

