package subway.controller;

import java.util.Scanner;

import subway.service.SectionService;
import subway.view.MainView;
import subway.view.SectionView;

public class SectionController {
	private final SectionView sectionView;
	private final MainView mainView;
	private final SectionService sectionService;
	private final Scanner scanner;

	public SectionController(Scanner scanner, SectionView sectionView, SectionService sectionService, MainView mainView) {
		this.scanner = scanner;
		this.sectionView = sectionView;
		this.mainView = mainView;
		this.sectionService = sectionService;
	}
	public void manageSection() {
		boolean back = true;
		while (back) {
			sectionView.printSectionView();
			mainView.printSelectView();
			String command = scanner.nextLine().trim();
			if (command.equals("1")) {
				sectionView.printAddSection();
				String lineName = scanner.nextLine().trim();
				sectionView.printAddStationName();
				String stationName = scanner.nextLine().trim();
				sectionView.printAddOrder();
				int position = Integer.parseInt(scanner.nextLine().trim());
				sectionService.addSection(lineName, stationName, position);
				sectionView.printSuccessSectionStation();
			}
			if (command.equals("2")) {
				sectionView.printDeleteSection();
				String lineName = scanner.nextLine().trim();
				sectionView.printDeleteStation();
				String stationName = scanner.nextLine().trim();
				sectionService.deleteSection(lineName, stationName);
				sectionView.printSuccessDeleteSection();
			}
			if (command.equals("B")) {
				back = false;
			}
		}
	}


}

