package subway.service;

import subway.domain.Station;
import subway.domain.repository.StationRepository;

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
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 역입니다.");
        }
    }

    public List<Station> getStations() {
        return stationRepository.stations();
    }
}
