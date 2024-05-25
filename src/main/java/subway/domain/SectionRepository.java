package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class SectionRepository {
	private static final List<Section> sections = new ArrayList<>();

	public static void addSection(Section section) {sections.add(section);}

	public static boolean isStationInSection(String stationName) {
		return sections.stream()
			.flatMap(section -> section.getStations().stream())
			.anyMatch(station -> station.getName().equals(stationName));
	}

	public static Optional<Section> findByLine(Line line) {
		return sections.stream()
			.filter(section -> Objects.equals(section.getLine(), line))
			.findFirst();
	}
}
