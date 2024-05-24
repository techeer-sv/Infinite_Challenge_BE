package subway.service;

import subway.data.DataInitializer;

public class SubwayService {
	private final DataInitializer dataInitializer;

	public SubwayService() {
		this.dataInitializer = new DataInitializer();
	}

	public void settingData() {
		dataInitializer.initializeStations();
		dataInitializer.initializeLines();
	}




}
