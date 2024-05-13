package subway.domain;

import subway.view.InputView;
import subway.view.OutputView;

public class StationService {
    private final OutputView outputView;
    private final InputView inputView;

    public StationService(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void manage(){
        outputView.stationManagementPage();
        String input = inputView.selectFunction();

        if(input.equals("1")){
            registerStation();
            return;
        }
        if(input.equals("2")){
            deleteStation();
            return;
        }
        if(input.equals("3")){
            listStation();
            return;
        }
        if(input.equals("B")) return;
    }

    private void registerStation(){
        String stationName = inputView.inputRegisterStation();

        if(stationName.length() < 2){
            System.out.println("[ERROR] 두 글자 이상 입력해야합니다.");
            return;
        }
        if(StationRepository.isExist(stationName)){
            System.out.println("[ERROR] 존재하는 역입니다.");
            return;
        }

        StationRepository.addStation(new Station(stationName));
        outputView.registeredStation();
    }

    private void deleteStation(){
        String stationName = inputView.inputDeleteStation();
        if(!StationRepository.deleteStation(stationName)){
            System.out.println("[ERROR] 역 삭제에 실패했습니다.");
        }
        outputView.deletedStation();
    }

    private void listStation(){
        StationRepository.stations().stream()
                .map(Station::getName)
                .forEach(name -> System.out.println("[INFO] " + name));
    }
}
