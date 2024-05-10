package subway.controller;

import subway.config.handler.SubwayException;
import subway.service.DataManager;
import subway.service.SectionManager;
import subway.view.ResponseView;

public class SectionController extends ManageController {
    private static SectionManager sectionManager;
    private static ResponseView response = new ResponseView();
    static SubwayException subwayException;


    public SectionController(DataManager manager){
        sectionManager = manager.getSectionManager();
        subwayException = manager.getSubwayException();
    }

    @Override
    public void work() {
        ask.sectionManage();
        ask.Function();
        try {
            String command = br.readLine();
            if (command.equals("1")) { // 등록
                register();
                return;
            }
            if (command.equals("2")) { // 삭제
                delete();
                return;
            }
            if (command.equals("B")) { // 되돌아가기
                return;
            }
            // 에러 발생시키기
            subwayException.notValidCommand();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void register() { // 노선, 역 이름, 순서 입력 받고 등록
        String line = getLine();
        sectionManager.register(line);

        ask.orderWhat("역 이름");
        String station = getStation();

        ask.orderWhere();
        int index = getIndex();

        sectionManager.insertSection(station, index);
        response.printInfo("구간이 등록되었습니다.");
    }

    public String getLine() {
        ask.orderWhat("노선");
        String line = "";
        try {
            line = br.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return line;
    }

    public String getStation() {
        try {
            return br.readLine();
        } catch (Exception e) {
            System.out.println("역 이름을 받을 수 없습니다. 다시 시도해주세요.");
            e.printStackTrace();
        }
        return null;
    }

    public int getIndex() {
        try {
            int index = Integer.parseInt(br.readLine());
            return index;
        } catch (Exception e) {
            System.out.println("입력값을 확인해주세요.");
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void delete() {
        try{
            ask.Name("삭제", "구간의 노선");
            String line = br.readLine();
            ask.Name("삭제", "구간의 역");
            String station = br.readLine();
            // manager에서 line 세팅. 함수 이름 고민중...
            // 알고리즘 빡 분리해야 할 듯함
            sectionManager.register(line);
            sectionManager.delete(station);
            response.printInfo("구간이 삭제되었습니다.");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
