package subway.controller.subControllers;

import subway.config.constants.Targets;
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
        if (!sectionManager.isEmpty(Targets.LINE.getTarget(), line)) {
            inputException.noCreatedLine();
            return false;
        }

        String sName = method.getStation();
        if (!sectionManager.isEmpty(Targets.STATION.getTarget(), sName)) {
            int index = method.getIndex();
            sectionManager.insertSection(sName, index);
        }
        response.printInfo("구간이 등록되었습니다.");
        return true;
    }

    @Override
    public boolean delete() {
        try {
            String line = method.getLine(DELETE, "구간의 노선");
            sectionManager.getLine(line);
            String station = method.getStation(sectionManager, DELETE, "구간의 역");

            if (!sectionManager.isEmpty(Targets.STATION.getTarget(), station)) { // TODO: 존재하지 않는 구간을 삭제하려 할 때 예외 처리 추가
                sectionManager.delete(station);
                response.printInfo("구간이 삭제되었습니다.");
            }
        } catch (IllegalArgumentException e) {
            System.err.println(Errors.VALID.getError());
            return false;
        }
        return true;
    }

    @Override
    public boolean read() {
        return false;
    }
}
