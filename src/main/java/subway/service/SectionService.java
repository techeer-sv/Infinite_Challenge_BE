package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Section;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.error.SectionErrorMessage;
import subway.view.error.StationErrorMessage;

public class SectionService {
	private final LineRepository lineRepository;
	private final SectionRepository sectionRepository;
	private final StationRepository stationRepository;

	public SectionService() {
		this.lineRepository = new LineRepository();
		this.sectionRepository = new SectionRepository();
		this.stationRepository = new StationRepository();
	}

	public void addSection(String lineName, String stationName, int position) {
		Line line = lineRepository.findLineByName(lineName)
			.orElseThrow(() -> new IllegalArgumentException(SectionErrorMessage.NOT_LINE_EXISTS.getMessage()));
		Station station = stationRepository.findStationByName(stationName)
			.orElseThrow(() -> new IllegalArgumentException(SectionErrorMessage.NOT_STATION_EXISTS.getMessage()));

		Section section = sectionRepository.findByLine(line)
			.orElseGet(() -> new Section(line));

		if (section.getStations().size() < 2 && position != 1) {
			throw new IllegalArgumentException(SectionErrorMessage.INSUFFICIENT_STATIONS.getMessage());
		}

		section.getStations().add(position - 1, station);
		sectionRepository.addSection(section);

	}

	public void removeSection(String lineName, String stationName) {
		Line line = lineRepository.findLineByName(lineName)
			.orElseThrow(() -> new IllegalArgumentException(SectionErrorMessage.NOT_LINE_EXISTS.getMessage()));
		Section section = sectionRepository.findByLine(line)
			.orElseThrow(() -> new IllegalArgumentException(SectionErrorMessage.NOT_LINE_EXISTS.getMessage()));

		if (section.getStations().size() <= 2) {
			throw new IllegalArgumentException(SectionErrorMessage.INSUFFICIENT_STATIONS.getMessage());
		}

		boolean removed = section.removeStation(stationName);
		if (!removed) {
			throw new IllegalArgumentException(SectionErrorMessage.UN_REMOVABLE.getMessage());
		}
	}
}
