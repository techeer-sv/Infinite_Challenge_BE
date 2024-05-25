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

	public SectionService(LineRepository lineRepository, SectionRepository sectionRepository, StationRepository stationRepository) {
		this.lineRepository = lineRepository;
		this.sectionRepository = sectionRepository;
		this.stationRepository = stationRepository;
	}
	public void addSection(String lineName, String stationName, int position) {
		Line line = validateLine(lineName);
		Station station = validateStation(stationName);
		Section section = validateAndCreateSection(line);

		if (section.getStations().size() < 2) {
			throw new IllegalArgumentException(SectionErrorMessage.INSUFFICIENT_STATIONS.getMessage());
		}

		section.getStations().add(position - 1, station);
		sectionRepository.addSection(section);

	}

	public void deleteSection(String lineName, String stationName) {
		Line line = validateLine(lineName);
		Section section = validtaeSection(line);

		if (section.getStations().size() <= 2) {
			throw new IllegalArgumentException(SectionErrorMessage.INSUFFICIENT_STATIONS.getMessage());
		}

		boolean delete = section.deleteStation(stationName);
		if (!delete) {
			throw new IllegalArgumentException(SectionErrorMessage.UN_REMOVABLE.getMessage());
		}
	}

	private Line validateLine(String lineName) {
		return lineRepository.findLineByName(lineName)
			.orElseThrow(() -> new IllegalArgumentException(SectionErrorMessage.NOT_LINE_EXISTS.getMessage()));
	}

	private Station validateStation(String stationName) {
		return stationRepository.findStationByName(stationName)
			.orElseThrow(() -> new IllegalArgumentException(SectionErrorMessage.NOT_STATION_EXISTS.getMessage()));
	}

	private Section validtaeSection(Line line) {
		return sectionRepository.findByLine(line)
			.orElseThrow(() -> new IllegalArgumentException(SectionErrorMessage.NOT_LINE_EXISTS.getMessage()));
	}

	private Section validateAndCreateSection(Line line) {
		return sectionRepository.findByLine(line)
			.orElseGet(() -> new Section(line));
	}
}
