package subway.domain;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;


public class SectionService {
    private final OutputView outputView;
    private final InputView inputView;

    public SectionService(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void manage(){
        outputView.sectionManagementPage();
        String input = inputView.selectFunction();

        if(input.equals("1")){
            registerSection();
            return;
        }
        if(input.equals("2")){
            deleteSection();
        }
        if(input.equals("B")) return;
    }

    private void registerSection(){
        String line = inputView.inputLineToRegisterSection();
        String station = inputView.inputStationToRegisterSection();
        int order = Integer.parseInt(inputView.inputOrder());

        if(!LineRepository.isExist(line)){
            System.out.println("존재하지 않는 노선");
            return;
        }
        if(!StationRepository.isExist(station)){
            System.out.println("존재하지 않는 역");
            return;
        }

        List<Station> stations = Subway.lines.get(line);
        if(stations.contains(new Station(station))){
            System.out.println("이미 존재하는 역");
        }

        stations.add(order, new Station(station));
        outputView.registeredSection();
    }

    private void deleteSection(){
        String line = inputView.inputDeleteLineOfSection();
        String station = inputView.inputDeleteStationOfSection();

        if(!LineRepository.isExist(line)){
            System.out.println("존재하지 않는 노선");
            return;
        }
        if(!StationRepository.isExist(station)){
            System.out.println("존재하지 않는 역");
            return;
        }

        List<Station> stations = Subway.lines.get(line);
        stations.remove(new Station(station));

    }
}
