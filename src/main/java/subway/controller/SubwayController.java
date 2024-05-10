package subway.controller;

import java.util.List;
import subway.common.ExceptionHander;
import subway.constant.LineCommand;
import subway.constant.MainCommand;
import subway.constant.SectionCommand;
import subway.constant.StationCommand;
import subway.domain.Subway;
import subway.service.SubwayService;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {

    private final OutputView outputView;
    private final InputView inputView;

    public SubwayController(
            final OutputView outputView,
            final InputView inputView,
            final SubwayService subwayService
    ) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.subwayService = subwayService;
    }

    private final SubwayService subwayService;

    public void start() {
        subwayService.initializeSubway();
        ExceptionHander.retryOnException(this::startSubway);
    }

    private void startSubway() {
        while (true) {
            outputView.printMainView();
            final String command = inputView.readCommand();
            final MainCommand mainCommand = MainCommand.from(command);
            if (mainCommand.equals(MainCommand.STATION_MANAGE)) {
                manageStation();
            }
            if (mainCommand.equals(MainCommand.LINE_MANAGE)) {
                manageLine();
            }
            if (mainCommand.equals(MainCommand.SECTION_MANAGE)) {
                manageSection();
            }
            if (mainCommand.equals(MainCommand.PRINT_SUBWAY)) {
                final Subway subway = subwayService.getSubway();
                outputView.printSubway(subway);
            }
        }
    }

    private void manageSection() {
        while (true) {
            outputView.printSectionManageView();
            final String sectionManageCommand = inputView.readCommand();
            final SectionCommand sectionCommand = SectionCommand.from(sectionManageCommand);
            if (sectionCommand.equals(SectionCommand.SAVE)) {
                final String inputLine = inputView.readLineName();
                final String inputStation = inputView.readStationName();
                final String inputIndex = inputView.readStationInputIndex();
                subwayService.addSubwayStation(inputLine, inputStation, inputIndex);
            }
            if (sectionCommand.equals(SectionCommand.DELETE)) {
                final String inputLine = inputView.readDeleteLineName();
                subwayService.deleteSubwayLine(inputLine);
            }
            if (sectionCommand.equals(SectionCommand.BACK)) {
                break;
            }
        }
    }

    private void manageLine() {
        while (true) {
            outputView.printLineManageView();
            final String lineManageCommand = inputView.readCommand();
            final LineCommand lineCommand = LineCommand.from(lineManageCommand);
            if (lineCommand.equals(LineCommand.SAVE)) {
                final String inputName = inputView.readSaveLineName();
                final String inputLineStartStationName = inputView.readLineStartStationName();
                final String inputLineEndStationName = inputView.readLineEndStatationName();
                subwayService.saveLine(inputName, inputLineStartStationName, inputLineEndStationName);
                outputView.printSubwayAddSuccess();
            }
            if (lineCommand.equals(LineCommand.DELETE)) {
                final String inputLineName = inputView.readDeleteLineName();
                subwayService.deleteLine(inputLineName);
                outputView.printSubwayDeleteSuccess();
            }
            if (lineCommand.equals(LineCommand.SELECT)) {
                List<String> lineNames = subwayService.getAllLine();
                outputView.printLines(lineNames);
            }
            if (lineCommand.equals(LineCommand.BACK)) {
                break;
            }
        }
    }

    private void manageStation() {
        while (true) {
            outputView.printStationManageView();
            final String stationManageCommand = inputView.readCommand();
            final StationCommand stationCommand = StationCommand.from(stationManageCommand);
            if (stationCommand.equals(StationCommand.SAVE)) {
                final String input = inputView.readSaveStationName();
                subwayService.saveStation(input);
            }
            if (stationCommand.equals(StationCommand.DELETE)) {
                final String input = inputView.readDeleteStationName();
                subwayService.deleteStation(input);
            }
            if (stationCommand.equals(StationCommand.SELECT)) {
                final List<String> stationsName = subwayService.getAllStations();
                outputView.printStations(stationsName);
            }
            if (stationCommand.equals(StationCommand.BACK)) {
                break;
            }
        }
    }
}
