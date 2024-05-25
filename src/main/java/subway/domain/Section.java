package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Section {
	private Line line;
	private List<Station> stations;

	public Section(Line line) {
		this.line = line;
		this.stations = new ArrayList<>();
	}

	public void addStation(Station station) {
		stations.add(station);
	}

	public List<Station> getStations() {
		return stations;
	}
}
