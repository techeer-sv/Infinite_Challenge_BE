package subway.service;

import java.util.List;
import java.util.stream.Collectors;

import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.error.StationErrorMessage;

public class StationService {
	public void addStation(String stationName) {
		if (stationName.length() < 2) {
			throw new IllegalArgumentException(StationErrorMessage.WRONG_NAME.getMessage());
		}

		if (StationRepository.stations().stream()
			.anyMatch(station -> station.getName().equals(stationName))) {
			throw new IllegalArgumentException(StationErrorMessage.ALREADY_EXISTS.getMessage());
		}

		Station newStation = new Station(stationName);
		StationRepository.addStation(newStation);
	}

	public void deleteStation(String stationName) {
		if (SectionRepository.isStationInSection(stationName)) {
			throw new IllegalArgumentException(StationErrorMessage.UN_REMOVABLE.getMessage());
		}

		if (!StationRepository.deleteStation(stationName)) {
			throw new IllegalArgumentException(StationErrorMessage.NOT_EXISTS.getMessage());
		}
	}

	public List<String> getStations() {
		return StationRepository.stations().stream()
			.map(Station::getName)
			.collect(Collectors.toList());
	}
}