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
import subway.view.error.SectionErrorMessage;
import subway.view.error.StationErrorMessage;

public class LineService {

	private final LineRepository lineRepository;
	private final SectionRepository sectionRepository;
	private final StationRepository stationRepository;

	public LineService(LineRepository lineRepository, SectionRepository sectionRepository, StationRepository stationRepository) {
		this.lineRepository = lineRepository;
		this.sectionRepository = sectionRepository;
		this.stationRepository = stationRepository;
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


	public void printAllLinesAndStations() {
		lineRepository.lines().stream()
			.forEach(line -> {
				System.out.println("[INFO] " + line.getName());
				System.out.println("[INFO] ---");
				Section section = sectionRepository.findByLine(line)
					.orElseThrow(() -> new IllegalStateException(SectionErrorMessage.NOT_LINE_EXISTS.getMessage()));
				section.getStations().forEach(station ->
					System.out.println("[INFO] " + station.getName()));
				System.out.println();
			});
	}

}

