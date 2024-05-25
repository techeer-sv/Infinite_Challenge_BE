package subway.controller;

import java.util.List;
import java.util.Scanner;

import subway.service.LineService;
import subway.view.LineView;
import subway.view.MainView;
import subway.view.command.CommandLine;

public class LineController {
	private final LineView lineView;
	private final MainView mainView;
	private final LineService lineService;
	private final Scanner scanner;

	public LineController(Scanner scanner, LineView lineView, LineService lineService, MainView mainView) {
		this.scanner = scanner;
		this.lineView = lineView;
		this.mainView = mainView;
		this.lineService = lineService;
	}

	void manageLine() {
		boolean back = true;
		while (back) {
			lineView.printLineView();
			mainView.printSelectView();
			String commandInput = scanner.nextLine().trim();
			CommandLine command = CommandLine.fromString(commandInput);
			if (command.equals(CommandLine.ADD_LINE)) {
				lineView.printAddLine();
				String lineName = scanner.nextLine().trim();
				lineView.printAddFirstLine();
				String startStationName = scanner.nextLine().trim();
				lineView.printAddLastLine();
				String endStationName = scanner.nextLine().trim();
				lineService.addLine(lineName, startStationName, endStationName);
				lineView.printSuccessAddLine();
			}
			if (command.equals(CommandLine.REMOVE_LINE)) {
				lineView.printDeleteLine();
				String lineName = scanner.nextLine().trim();
				lineService.deleteLine(lineName);
				lineView.printSuccessDeleteLine();
			}
			if (command.equals(CommandLine.VIEW_LINES)) {
				lineView.printSelectLine();
				List<String> lines = lineService.getLines();
				lineView.printLineList(lines);
			}
			if (command.equals(CommandLine.BACK)) {
				back = false;
			}
		}
	}

	public void printLine() {
		lineService.printAllLinesAndStations();
	}


}
