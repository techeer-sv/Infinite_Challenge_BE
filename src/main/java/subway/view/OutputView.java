package subway.view;

import java.util.List;
import java.util.Map.Entry;
import subway.constant.message.Processmessage;
import subway.domain.Line;
import subway.domain.Station;
import subway.domain.Subway;

public class OutputView {

    public void printMainView() {
        System.out.println("## 메인 화면\n"
                + "1. 역 관리\n"
                + "2. 노선 관리\n"
                + "3. 구간 관리\n"
                + "4. 지하철 노선도 출력\n"
                + "Q. 종료");
    }

    public void printStations(final List<String> inputs) {
        for (String input : inputs) {
            System.out.println(Processmessage.SUCCESS_PREFIX.toMessage() + input);
        }
    }

    public void printStationManageView() {
        System.out.println("## 역 관리 화면\n"
                + "1. 역 등록\n"
                + "2. 역 삭제\n"
                + "3. 역 조회\n"
                + "B. 돌아가기");
    }

    public void printLineManageView() {
        System.out.println("## 노선 관리 화면\n"
                + "1. 노선 등록\n"
                + "2. 노선 삭제\n"
                + "3. 노선 조회\n"
                + "B. 돌아가기");
    }

    public void printSubwayAddSuccess() {
        System.out.println(Processmessage.SUCCESS_PREFIX.toMessage() + "지하철 노선이 등록되었습니다.");
    }

    public void printSubwayDeleteSuccess() {
        System.out.println(Processmessage.SUCCESS_PREFIX.toMessage() + "지하철 노선이 삭제되었습니다.");
    }

    public void printLines(final List<String> inputs) {
        for (String input : inputs) {
            System.out.println(Processmessage.SUCCESS_PREFIX.toMessage() + input);
        }
    }

    public void printSectionManageView() {
        System.out.println("## 구간 관리 화면\n"
                + "1. 구간 등록\n"
                + "2. 구간 삭제\n"
                + "B. 돌아가기");
    }

    public void printSubway(final Subway subway) {
        for (Entry<Line, List<Station>> entry : subway.getSubway().entrySet()) {
            printLines(entry);
            printStations(entry);
        }
    }

    private void printLines(final Entry<Line, List<Station>> entry) {
        final Line line = entry.getKey();
        System.out.println(Processmessage.SUCCESS_PREFIX.toMessage() + line.getName().toString());
        System.out.println(Processmessage.SUCCESS_PREFIX.toMessage() + "---");
    }

    private void printStations(final Entry<Line, List<Station>> entry) {
        for (Station s : entry.getValue()) {
            System.out.println(Processmessage.SUCCESS_PREFIX.toMessage() + s.getName().toString());
        }
        System.out.println();
    }
}
