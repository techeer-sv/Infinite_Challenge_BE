package subway.view;

public class OutputView {
    public void mainPage(){
        System.out.println("## 메인 화면\n" +
                "1. 역 관리\n" +
                "2. 노선 관리\n" +
                "3. 구간 관리\n" +
                "4. 지하철 노선도 출력\n" +
                "Q. 종료\n");
    }

    public void stationManagementPage(){
        System.out.println("## 역 관리 화면\n" +
                "1. 역 등록\n" +
                "2. 역 삭제\n" +
                "3. 역 조회\n" +
                "B. 돌아가기\n");
    }

    public void registeredStation(){
        System.out.println("[INFO] 지하철 역이 등록되었습니다.\n");
    }

    public void deletedStation(){
        System.out.println("[INFO] 지하철 역이 삭제되었습니다.\n");
    }
}
