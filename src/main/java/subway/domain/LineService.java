package subway.domain;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LineService {
    private final OutputView outputView;
    private final InputView inputView;

    public LineService(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void manage(){
        outputView.lineManagementPage();
        String input = inputView.selectFunction();

        if(input.equals("1")){
            registerLine();
            return;
        }
        if(input.equals("2")){
            deleteLine();
            return;
        }
        if(input.equals("3")){
            listLines();
            return;
        }
        if(input.equals("B")) return;
    }

    private void registerLine(){
        String lineName = inputView.inputRegisterLine();
        String startStationName = inputView.inputStartStation();
        String endStationName = inputView.inputEndStation();

        if(lineName.length() < 2){
            System.out.println("두 글자 이상");
            return;
        }
        Line line = new Line(lineName);

        if(Subway.lines.containsKey(line)){
            System.out.println("이미 존재하는 노선");
        }
        if(!StationRepository.isExist(startStationName)){
            System.out.println("존재하지 않는 역");
            return;
        }
        if(!StationRepository.isExist(endStationName)){
            System.out.println("존재하지 않는 역");
            return;
        }

        LineRepository.addLine(line);

        List<Station> stations = new ArrayList<>();
        stations.add(new Station(startStationName));
        stations.add(new Station(endStationName));

        Subway.lines.put(line, stations);
        outputView.registeredLine();
    }

    public void deleteLine(){
        String stationName = inputView.inputDeleteLine();
        if(!LineRepository.deleteLineByName(stationName)){
            System.out.println("존재하지 않는 노선");
            return;
        }
        Line line = new Line(stationName);
        Subway.lines.remove(line);
        outputView.deletedLine();
    }

    public void listLines(){
        LineRepository.lines().stream()
                .map(Line::getName)
                .forEach(name -> System.out.println("[INFO} " + name));
    }

}
