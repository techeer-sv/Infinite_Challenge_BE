package subway.controller;

import java.util.Scanner;

import subway.service.SubwayService;
import subway.view.LineView;
import subway.view.MainView;
import subway.view.SectionView;
import subway.view.StationView;

public class MainController {
	private final StationController stationController;
	private final LineController lineController;
	private final SectionController sectionController;
	private final MainView mainView;
	private final Scanner scanner;
	private final SubwayService subwayService;

	public MainController(Scanner scanner) {
		this.scanner = scanner;
		this.stationController = new StationController(scanner);
		this.lineController = new LineController(scanner);
		this.sectionController = new SectionController(scanner);
		this.subwayService = new SubwayService();
		this.mainView = new MainView();
	}

	public void run() {
		subwayService.settingData();
		selectSubway();
	}

	public void selectSubway() {
		boolean quit = true;
		while (quit){
			mainView.printMainView();
			mainView.printSelectView();
			String command = scanner.nextLine().trim();
			if (command.equals("1")) {
				stationController.manageStation();
			}
			if (command.equals("2")) {
				lineController.manageLine();
			}
			if (command.equals("3")) {
				sectionController.manageSection();
			}
			if (command.equals("4")) {
				sectionController.printLine();
			}
			if (command.equals("Q")) {
				quit = false;
			}
		}
	}


}
