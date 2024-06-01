package subway.service;

import subway.domain.Station;
import subway.domain.repository.StationRepository;
import subway.global.error.ErrorMessage;

import java.util.List;

public class StationService {

    private final StationRepository stationRepository;

    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public void addStation(String name) {
        Station station = new Station(name);
        stationRepository.addStation(station);
    }

    public void deleteStation(String name) {
        if (!stationRepository.deleteStation(name)) {
            throw new IllegalArgumentException(ErrorMessage.STATION_NOT_FOUND);
        }
    }

    public List<Station> getStations() {
        return stationRepository.stations();
    }

    public Station findStationByName(String name, String errorMessage) {
        return stationRepository.stations().stream()
                .filter(s -> s.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(errorMessage));
    }
}
