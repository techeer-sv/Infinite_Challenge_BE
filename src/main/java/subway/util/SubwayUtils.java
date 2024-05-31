package subway.util;

import subway.service.SubwayService;

// ENUM 사용으로 미사용 --> ㅠ_ㅠ
public class SubwayUtils {

    public static void addStations(SubwayService subwayService, String... stations) {
        for (String station : stations) {
            subwayService.addStation(station);
        }
    }

    public static void addLines(SubwayService subwayService, Object[][] lines) {
        for (Object[] line : lines) {
            String lineName = (String) line[0];
            String[] stations = (String[]) line[1];
            subwayService.addLine(lineName, stations);
        }
    }
}
