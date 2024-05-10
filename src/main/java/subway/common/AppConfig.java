package subway.common;

import subway.controller.SubwayController;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.domain.Subway;
import subway.service.SubwayService;
import subway.view.InputView;
import subway.view.OutputView;

public class AppConfig {

    private static AppConfig instance;

    private AppConfig() {
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    public SubwayController subwayController() {
        return new SubwayController(outputView(), inputView(), subwayService());
    }

    private OutputView outputView() {
        return new OutputView();
    }
    private InputView inputView() {
        return new InputView();
    }

    private SubwayService subwayService() {
        return new SubwayService(subway(), lineRepository(), stationRepository());
    }

    private Subway subway() {
        return new Subway();
    }

    private LineRepository lineRepository() {
        return new LineRepository();
    }

    private StationRepository stationRepository() {
        return new StationRepository();
    }
}
