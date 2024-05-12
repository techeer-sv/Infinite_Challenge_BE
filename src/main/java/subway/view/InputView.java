package subway.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);
    public String selectFunction(){
        System.out.println("## 원하는 기능을 선택하세요");
        return scanner.nextLine();
    }

    public String inputRegisterStation(){
        System.out.println("## 등록할 역 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public String inputDeleteStation(){
        System.out.println("## 삭제할 역 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public String inputRegisterLine(){
        System.out.println("## 등록할 노선 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public String inputStartStation(){
        System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public String inputEndStation(){
        System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public String inputDeleteLine(){
        System.out.println("## 삭제할 노선 이름을 입력하세요.");
        return scanner.nextLine();
    }
}
