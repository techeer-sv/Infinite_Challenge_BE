package subway.data;

import java.util.List;
import java.util.Map;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Section;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class DataInitializer {
	private final LineRepository lineRepository;
	private final StationRepository stationRepository;
	private final SectionRepository sectionRepository;

	public DataInitializer(LineRepository lineRepository, StationRepository stationRepository, SectionRepository sectionRepository) {
		this.lineRepository = lineRepository;
		this.stationRepository = stationRepository;
		this.sectionRepository = sectionRepository;
	}


	public void initializeStations() {
		List<String> stationData = List.of("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
		stationData.forEach(stationName -> stationRepository.addStation(new Station(stationName)));
	}

	public void initializeLines() {
		Map<String, List<String>> lineData = Map.of(
			"2호선", List.of("교대역", "강남역", "역삼역"),
			"3호선", List.of("교대역", "남부터미널역", "양재역", "매봉역"),
			"신분당선", List.of("강남역", "양재역", "양재시민의숲역")
		);

		lineData.forEach((lineName, stationNames) -> {
			Line line = new Line(lineName);
			Section section = new Section(line);
			stationNames.forEach(stationName -> section.addStation(new Station(stationName)));
			lineRepository.addLine(line);
			sectionRepository.addSection(section);
		});
	}


}
