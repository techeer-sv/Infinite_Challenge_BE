package subway.controller.controllers;

import subway.config.handler.SubwayException;
import subway.controller.utils.ClassifyMethods;
import subway.controller.utils.Controller;
import subway.service.InitSubwayValues;
import subway.service.SectionManager;

public class SectionController extends ClassifyMethods {
    private static SectionManager sectionManager;
    static SubwayException subwayException;

    public SectionController(final InitSubwayValues manager){
        sectionManager = manager.getSectionManager();
        subwayException = manager.getSubwayException();
    }

    @Override
    public boolean sendRequest(final Controller controller, final String command){
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
        if(!sectionManager.isEmpty(line)){
            return false;
        }

        String station = method.getStation();
        int index = method.getIndex();
        if(index == -1){
            return false;
        }

        sectionManager.insertSection(station, index);
        response.printInfo("구간이 등록되었습니다.");
        return true;
    }

    @Override
    public boolean delete() {
        try{
            String line = method.getLine(DELETE, "구간의 노선");
            String station = method.getStation(sectionManager, DELETE, "구간의 역");

            if(sectionManager.isEmpty(line)){
                sectionManager.delete(station);
                response.printInfo("구간이 삭제되었습니다.");
            }
        } catch (Exception e){
            subwayException.unexpected();
            return false;
        }
        return true;
    }
    @Override
    public boolean read() {return false;}
}
