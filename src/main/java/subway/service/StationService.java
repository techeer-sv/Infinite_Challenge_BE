package subway.service;

import java.util.List;
import java.util.stream.Collectors;

import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.error.StationErrorMessage;

public class StationService {
	private final StationRepository stationRepository;
	private final SectionRepository sectionRepository;

	public StationService(StationRepository stationRepository, SectionRepository sectionRepository) {
		this.stationRepository = stationRepository;
		this.sectionRepository = sectionRepository;
	}
	public void addStation(String stationName) {
		if (stationName.length() < 2) {
			throw new IllegalArgumentException(StationErrorMessage.WRONG_NAME.getMessage());
		}

		if (stationRepository.stations().stream()
			.anyMatch(station -> station.getName().equals(stationName))) {
			throw new IllegalArgumentException(StationErrorMessage.ALREADY_EXISTS.getMessage());
		}

		Station newStation = new Station(stationName);
		stationRepository.addStation(newStation);
	}

	public void deleteStation(String stationName) {
		if (sectionRepository.isStationInSection(stationName)) {
			throw new IllegalArgumentException(StationErrorMessage.UN_REMOVABLE.getMessage());
		}

		if (!stationRepository.deleteStation(stationName)) {
			throw new IllegalArgumentException(StationErrorMessage.NOT_EXISTS.getMessage());
		}
	}

	public List<String> getStations() {
		return stationRepository.stations().stream()
			.map(Station::getName)
			.collect(Collectors.toList());
	}
}