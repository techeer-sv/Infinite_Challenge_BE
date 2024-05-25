package subway.controller;

import java.util.List;
import java.util.Scanner;

import subway.service.LineService;
import subway.view.LineView;
import subway.view.MainView;

public class LineController {
	private final LineView lineView;
	private final MainView mainView;
	private final LineService lineService;
	private final Scanner scanner;

	public LineController(Scanner scanner) {
		this.scanner = scanner;
		this.lineView = new LineView();
		this.mainView = new MainView();
		this.lineService = new LineService();
	}

	void manageLine() {
		boolean back = true;
		while (back) {
			lineView.printLineView();
			mainView.printSelectView();
			String command = scanner.nextLine().trim();
			if (command.equals("1")) {
				lineView.printAddLine();
				String lineName = scanner.nextLine().trim();
				lineView.printAddFirstLine();
				String startStationName = scanner.nextLine().trim();
				lineView.printAddLastLine();
				String endStationName = scanner.nextLine().trim();
				lineService.addLine(lineName, startStationName, endStationName);
				lineView.printSuccessAddLine();
			}
			if (command.equals("2")) {
				lineView.printDeleteLine();
				String lineName = scanner.nextLine().trim();
				lineService.deleteLine(lineName);
				lineView.printSuccessDeleteLine();
			}
			if (command.equals("3")) {
				lineView.printSelectLine();
				List<String> lines = lineService.getLines();
				lineView.printLineList(lines);
			}
			if (command.equals("B")) {
				back = false;
			}
		}
	}
}
