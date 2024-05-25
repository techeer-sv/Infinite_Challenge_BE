package subway.common;

import java.util.Scanner;

import subway.controller.LineController;
import subway.controller.MainController;
import subway.controller.SectionController;
import subway.controller.StationController;
import subway.data.DataInitializer;
import subway.domain.LineRepository;
import subway.domain.SectionRepository;
import subway.domain.StationRepository;
import subway.service.LineService;
import subway.service.SectionService;
import subway.service.StationService;
import subway.service.SubwayService;
import subway.view.LineView;
import subway.view.MainView;
import subway.view.SectionView;
import subway.view.StationView;

public class AppConfig {

	public MainController mainController(Scanner scanner) {

		MainView mainView = new MainView();
		StationView stationView = new StationView();
		LineView lineView = new LineView();
		SectionView sectionView = new SectionView();
		DataInitializer dataInitializer = new DataInitializer();

		StationRepository stationRepository = new StationRepository();
		LineRepository lineRepository = new LineRepository();
		SectionRepository sectionRepository = new SectionRepository();

		StationService stationService = new StationService(stationRepository, sectionRepository);
		LineService lineService = new LineService(lineRepository, sectionRepository, stationRepository);
		SectionService sectionCapService = new SectionService(lineRepository, sectionRepository, stationRepository);
		SubwayService subwayService = new SubwayService(dataInitializer);

		StationController stationController = new StationController(scanner, stationView, stationService, mainView);
		LineController lineController = new LineController(scanner, lineView, lineService, mainView);
		SectionController sectionController = new SectionController(scanner, sectionView, sectionCapService, mainView);

		return new MainController(scanner, stationController, lineController, sectionController, subwayService, mainView);
	}
}
