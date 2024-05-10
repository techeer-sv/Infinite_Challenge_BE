package subway;

import java.util.Scanner;
import subway.domain.*;

public class SubwaySystem {
    private final Scanner scanner;

    public SubwaySystem(Scanner scanner) { this.scanner = scanner;}

    public void run() {
        boolean keepRunning = true;
        while (keepRunning) {
            showMainMenu();
            String command = scanner.nextLine().trim();
            switch (command) {
                case "1":
                    manageStations();
                    break;
                case "2":
                    manageLines();
                    break;
                case "3":
                    manageSections();
                    break;
                case "4":
                    printSubwayMap();
                    break;
                case "Q":
                case "q":
                    System.out.println("[INFO] 프로그램을 종료합니다.");
                    keepRunning = false;
                    break;
                default:
                    System.out.println("[ERROR] 선택할 수 없는 기능입니다.");
            }
        }
    }

    private void showMainMenu() {
        System.out.println("\n## 메인 화면");
        System.out.println("1. 역 관리");
        System.out.println("2. 노선 관리");
        System.out.println("3. 구간 관리");
        System.out.println("4. 지하철 노선도 출력");
        System.out.println("Q. 종료");
        System.out.print("## 원하는 기능을 선택하세요: ");
    }

    private void manageStations() {
        while (true) {
            System.out.println("\n## 역 관리 화면");
            System.out.println("1. 역 등록");
            System.out.println("2. 역 삭제");
            System.out.println("3. 역 조회");
            System.out.println("B. 돌아가기");
            System.out.print("## 원하는 기능을 선택하세요: ");
            String command = scanner.nextLine().trim();
            switch (command) {
                case "1":
                    addStation();
                    return;
                case "2":
                    removeStation();
                    return;
                case "3":
                    showStations();
                    return;
                case "B":
                case "b":
                    return;
                default:
                    System.out.println("[ERROR] 선택할 수 없는 기능입니다.");
            }
        }
    }

    private void addStation() {
        System.out.print("## 등록할 역 이름을 입력하세요: ");
        String stationName = scanner.nextLine().trim();
        if (StationRepository.exists(stationName)) {
            System.out.println("[ERROR] 이미 등록된 역 이름입니다.");
        } else {
            StationRepository.addStation(new Station(stationName));
            System.out.println("[INFO] 지하철 역이 등록되었습니다.");
        }
    }

    private void removeStation() {
        System.out.print("## 삭제할 역 이름을 입력하세요: ");
        String stationName = scanner.nextLine().trim();
        if (StationRepository.deleteStation(stationName)) {
            System.out.println("[INFO] 지하철 역이 삭제되었습니다.");
        } else {
            System.out.println("[ERROR] 역이 존재하지 않거나 삭제할 수 없습니다.");
        }
    }

    private void showStations() {
        System.out.println("## 역 목록");
        for (Station station : StationRepository.stations()) {
            System.out.println("[INFO] " + station.getName());
        }
    }


    private void manageLines() {
        while (true) {
            System.out.println("\n## 노선 관리 화면");
            System.out.println("1. 노선 등록");
            System.out.println("2. 노선 삭제");
            System.out.println("3. 노선 조회");
            System.out.println("B. 돌아가기");
            System.out.print("## 원하는 기능을 선택하세요: ");
            String command = scanner.nextLine().trim();
            switch (command) {
                case "1":
                    addLine();
                    return;
                case "2":
                    removeLine();
                    return;
                case "3":
                    showLines();
                    return;
                case "B":
                case "b":
                    return;
                default:
                    System.out.println("[ERROR] 선택할 수 없는 기능입니다.");
            }
        }
    }

    private void addLine() {
        System.out.print("## 등록할 노선 이름을 입력하세요: ");
        String lineName = scanner.nextLine().trim();
        if (LineRepository.exists(lineName)) {
            System.out.println("[ERROR] 이미 등록된 노선 이름입니다.");
        } else {
            LineRepository.addLine(new Line(lineName));
            System.out.println("[INFO] 지하철 노선이 등록되었습니다.");
        }
    }

    private void removeLine() {
        System.out.print("## 삭제할 노선 이름을 입력하세요: ");
        String lineName = scanner.nextLine().trim();
        if (LineRepository.deleteLineByName(lineName)) {
            System.out.println("[INFO] 지하철 노선이 삭제되었습니다.");
        } else {
            System.out.println("[ERROR] 노선이 존재하지 않거나 삭제할 수 없습니다.");
        }
    }

    private void showLines() {
        System.out.println("## 노선 목록");
        for (Line line : LineRepository.lines()) {
            System.out.println("[INFO] " + line.getName());
        }
    }


    private void manageSections() {
        while (true) {
            System.out.println("\n## 구간 관리 화면");
            System.out.println("1. 구간 등록");
            System.out.println("2. 구간 삭제");
            System.out.println("B. 돌아가기");
            System.out.print("## 원하는 기능을 선택하세요: ");
            String command = scanner.nextLine().trim();
            switch (command) {
                case "1":
                    addSection();
                    return;
                case "2":
                    removeSection();
                    return;
                case "B":
                case "b":
                    return;
                default:
                    System.out.println("[ERROR] 선택할 수 없는 기능입니다.");
            }
        }
    }

    private void addSection() {
        System.out.print("## 등록할 구간의 노선 이름을 입력하세요: ");
        String lineName = scanner.nextLine().trim();
        Line line = LineRepository.getLine(lineName);
        if (line == null) {
            System.out.println("[ERROR] 노선이 존재하지 않습니다.");
            return;
        }

        System.out.print("## 등록할 구간의 역 이름을 입력하세요: ");
        String stationName = scanner.nextLine().trim();
        Station station = StationRepository.getStation(stationName);
        if (station == null) {
            System.out.println("[ERROR] 역이 존재하지 않습니다.");
            return;
        }

        System.out.print("## 구간 순서를 입력하세요: ");
        int order = Integer.parseInt(scanner.nextLine().trim());
        if (order < 1 || order > line.getStations().size() + 1) {
            System.out.println("[ERROR] 유효하지 않은 구간 순서입니다.");
            return;
        }

        line.addStationAt(station, order - 1);
        System.out.println("[INFO] 구간이 등록되었습니다.");
    }

    private void removeSection() {
        System.out.print("## 삭제할 구간의 노선 이름을 입력하세요: ");
        String lineName = scanner.nextLine().trim();
        Line line = LineRepository.getLine(lineName);
        if (line == null) {
            System.out.println("[ERROR] 노선이 존재하지 않습니다.");
            return;
        }

        System.out.print("## 삭제할 구간의 역 이름을 입력하세요: ");
        String stationName = scanner.nextLine().trim();
        if (!line.removeStationByName(stationName)) {
            System.out.println("[ERROR] 구간 삭제에 실패했습니다.");
        } else {
            System.out.println("[INFO] 구간이 삭제되었습니다.");
        }
    }


    private void printSubwayMap() {
        System.out.println("\n## 지하철 노선도");
        for (Line line : LineRepository.lines()) {
            System.out.println("[INFO] " + line.getName());
            System.out.println("[INFO] ---");
            for (Station station : line.getStations()) {
                System.out.println("[INFO] " + station.getName());
            }
        }
    }

}
