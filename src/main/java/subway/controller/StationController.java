package subway.controller;

import java.util.List;
import java.util.Scanner;

import subway.service.StationService;
import subway.view.MainView;
import subway.view.StationView;

public class StationController {
	private final StationView stationView;
	private final MainView mainView;
	private final StationService stationService;
	private final Scanner scanner;

	public StationController(Scanner scanner, StationView stationView, StationService stationService, MainView mainView) {
		this.scanner = scanner;
		this.stationView = stationView;
		this.mainView = mainView;
		this.stationService = stationService;
	}

	public void manageStation() {
		boolean back = true;
		while (back) {
			stationView.printStationView();
			mainView.printSelectView();
			String command = scanner.nextLine().trim();
			if (command.equals("1")) {
				stationView.printAddStation();
				String stationName = scanner.nextLine().trim();
				stationService.addStation(stationName);
				stationView.printSuccessAddStation();
			}
			if (command.equals("2")) {
				stationView.printDeleteStation();
				String stationName = scanner.nextLine().trim();
				stationService.deleteStation(stationName);
				stationView.printSuccessDeleteStation();
			}
			if (command.equals("3")) {
				stationView.printSelectStation();
				List<String> stations = stationService.getStations();
				stationView.printStationList(stations);
			}
			if (command.equals("B")) {
				back = false;
			}
		}
	}


}
