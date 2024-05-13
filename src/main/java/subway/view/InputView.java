package subway.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public String readCommand() {
        System.out.println("## 원하는 기능을 선택하세요.");
        final String command = scanner.next();
        return command;
    }

    public String readSaveStationName() {
        System.out.println("## 등록할 역 이름을 입력하세요.");
        final String input = scanner.next();
        return input;

    }

    public String readDeleteStationName() {
        System.out.println("## 삭제할 역 이름을 입력하세요.");
        final String input = scanner.next();
        return input;
    }

    public String readSaveLineName() {
        System.out.println("## 등록할 노선 이름을 입력하세요.");
        final String input = scanner.next();
        return input;
    }
    public String readDeleteLineName() {
        System.out.println("## 삭제할 노선 이름을 입력하세요.");
        final String input = scanner.next();
        return input;
    }

    public String readLineStartStationName() {
        System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        final String input = scanner.next();
        return input;
    }

    public String readLineEndStatationName() {
        System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        final String input = scanner.next();
        return input;
    }

    public String readLineName() {
        System.out.println("## 노선을 입력하세요.\n");
        final String input = scanner.next();
        return input;
    }

    public String readStationName() {
        System.out.println("## 역이름을 입력하세요.\n");
        final String input = scanner.next();
        return input;
    }

    public String readStationInputIndex() {
        System.out.println("## 순서를 입력하세요.\n");
        final String input = scanner.next();
        return input;
    }
}
