package subway.controller;

import java.util.Scanner;

import subway.service.LineService;
import subway.service.SectionService;
import subway.service.StationService;
import subway.service.SubwayService;
import subway.view.LineView;
import subway.view.MainView;
import subway.view.SectionView;
import subway.view.StationView;
import subway.view.command.CommandMain;

public class MainController {
	private final StationController stationController;
	private final LineController lineController;
	private final SectionController sectionController;
	private final MainView mainView;
	private final Scanner scanner;
	private final SubwayService subwayService;


	public MainController(Scanner scanner, StationController stationController, LineController lineController,
		SectionController sectionController, SubwayService subwayService, MainView mainView
	) {
		this.scanner = scanner;
		this.stationController = stationController;
		this.lineController = lineController;
		this.sectionController = sectionController;
		this.subwayService = subwayService;
		this.mainView = mainView;
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
			String commandInput = scanner.nextLine().trim();
			CommandMain command = CommandMain.fromString(commandInput);
			if (command.equals(CommandMain.MANAGE_STATION)) {
				stationController.manageStation();
			}
			if (command.equals(CommandMain.MANAGE_LINE)) {
				lineController.manageLine();
			}
			if (command.equals(CommandMain.MANAGE_SECTION)) {
				sectionController.manageSection();
			}
			if (command.equals(CommandMain.PRINT_LINE_MAP)) {
				lineController.printLine();
			}
			if (command.equals(CommandMain.QUIT)) {
				quit = false;
			}
		}
	}


}
