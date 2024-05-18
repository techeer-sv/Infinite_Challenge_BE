package subway.controller.subControllers;

import subway.config.constants.views.Errors;
import subway.config.handler.InputException;
import subway.config.handler.SubwayException;
import subway.controller.utils.ClassifyMethods;
import subway.controller.utils.Controller;
import subway.service.InitSubwayValues;
import subway.service.SectionManager;

public class SectionController extends ClassifyMethods {
    private static SectionManager sectionManager;
    static SubwayException subwayException;
    InputException inputException = new InputException();

    public SectionController(final InitSubwayValues manager) {
        sectionManager = manager.getSectionManager();
        subwayException = manager.getSubwayException();
    }

    @Override // 구간 조회 없
    public boolean sendRequest(final Controller controller, final String command) {
        if (command.equals(REGISTER_COMMAND)) { // 등록
            return controller.register();
        }
        if (command.equals(DELETE_COMMAND)) { // 삭제
            return controller.delete();
        }
        if (command.equals(BACK_COMMAND)) { // 되돌아가기
            return true;
        }
        subwayException.notValidCommand();
        return false;
    }

    @Override
    public boolean register() { // 노선, 역 이름, 순서 입력 받고 등록
        String line = method.getLine();
        String station = method.getStation();
        if(isEmptySpace(line, station)) return false;
        if(lineHaveStation(line, station)){
            inputException.alreadyWithStation();
            return false;
        }
        int index = method.getIndex();
        sectionManager.insertSection(station, index);

        return setPrint.printResult(REGISTER, SECTION, true);
    }

    public boolean isEmptySpace(String line, String station){
        return sectionManager.isEmptySpace(line, station);
    }

    public boolean lineHaveStation(String line, String station){
        return sectionManager.lineHaveStation(line, station);
    }

    @Override
    public boolean delete() {
        String line = method.getLine(DELETE, "구간의 노선");
        sectionManager.getLine(line);
        String station = method.getStation(sectionManager, DELETE, "구간의 역");

        return deleteSection(line, station) == true;
    }

    public boolean deleteSection(String line, String station) {
        if (isEmptySpace(line, station)) return false;
        if (!lineHaveStation(line, station)) {
            inputException.noStation();
            return false;
        }
        if (!sectionManager.isDeletable(line)) {
            inputException.underTwoStation();
            return false;
        }
        sectionManager.delete(station);
        return setPrint.printResult(DELETE, STATION, true);
    }

    @Override
    public boolean read() {
        return false;
    }
}
