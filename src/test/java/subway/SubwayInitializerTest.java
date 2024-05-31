package subway;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SubwayInitializerTest {

    @Nested
    @DisplayName("SubwayInitializer")
    class SubwayService_Init {
        SubwayInitializer subwayInitializer;
        SubwayService subwayService;

        @BeforeEach
        void setUp() {
            subwayService = new SubwayService();
            subwayInitializer = new SubwayInitializer(subwayService);
        }

        @Test
        @DisplayName("지하철 초기화")
        void initSubwayLine() {
            subwayInitializer.initialize();

            // 지하철 역 초기화
            assertStationsInitialized(StationRepository.stations());

            // 지하철 노선 초기화
            assertLinesInitialized(LineRepository.lines());
        }
        private void assertStationsInitialized(List<Station> stations) {
            assertEquals(7, stations.size());
            assertAll("stations",
                    () -> assertTrue(stations.stream().anyMatch(station -> station.getName().equals("교대역"))),
                    () -> assertTrue(stations.stream().anyMatch(station -> station.getName().equals("강남역"))),
                    () -> assertTrue(stations.stream().anyMatch(station -> station.getName().equals("역삼역"))),
                    () -> assertTrue(stations.stream().anyMatch(station -> station.getName().equals("남부터미널역"))),
                    () -> assertTrue(stations.stream().anyMatch(station -> station.getName().equals("양재역"))),
                    () -> assertTrue(stations.stream().anyMatch(station -> station.getName().equals("양재시민의숲역"))),
                    () -> assertTrue(stations.stream().anyMatch(station -> station.getName().equals("매봉역")))
            );
        }

        private void assertLinesInitialized(List<Line> lines) {
            assertEquals(3, lines.size());

            assertLine(lines, "2호선", new String[]{"교대역", "강남역", "역삼역"});
            assertLine(lines, "3호선", new String[]{"교대역", "남부터미널역", "양재역", "매봉역"});
            assertLine(lines, "신분당선", new String[]{"강남역", "양재역", "양재시민의숲역"});
        }

        private void assertLine(List<Line> lines, String lineName, String[] stationNames) {
            Line line = lines.stream().filter(l -> l.getName().equals(lineName)).findFirst().orElse(null);

            assertNotNull(line, lineName);
            assertEquals(stationNames.length, line.getStations().size(), lineName);

            for (int i = 0; i < stationNames.length; i++) {
                assertEquals(stationNames[i], line.getStations().get(i).getName(), lineName);
            }
        }
    }
}