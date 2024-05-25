package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class SectionRepository {
	private static final List<Section> sections = new ArrayList<>();

	public static void addSection(Section section) {sections.add(section);}

	public static boolean isStationInSection(String stationName) {
		return sections.stream()
			.flatMap(section -> section.getStations().stream())
			.anyMatch(station -> station.getName().equals(stationName));
	}
}
