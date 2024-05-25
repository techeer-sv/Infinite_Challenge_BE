package subway.service;

import subway.data.DataInitializer;

public class SubwayService {
	private final DataInitializer dataInitializer;

	public SubwayService(DataInitializer dataInitializer) {
		this.dataInitializer = dataInitializer;
	}

	public void settingData() {
		dataInitializer.initializeStations();
		dataInitializer.initializeLines();
	}

}
