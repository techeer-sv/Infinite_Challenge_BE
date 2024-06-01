package subway;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import subway.domain.Line;
import subway.domain.Station;
import subway.domain.repository.LineRepository;
import subway.domain.repository.StationRepository;
import subway.global.error.ErrorMessage;
import subway.service.LineService;
import subway.service.StationService;
import subway.service.SubwayService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SubwayServiceTest {
    private SubwayService subwayService;
    private StationRepository stationRepository;
    private LineRepository lineRepository;

    @BeforeEach
    void setUp() {
        stationRepository = new StationRepository();
        lineRepository = new LineRepository();
        StationService stationService = new StationService(stationRepository);
        LineService lineService = new LineService(lineRepository, stationRepository, stationService);
        subwayService = new SubwayService(stationService, lineService);
        stationRepository.clear();
        lineRepository.clear();
    }

    @Nested
    @DisplayName("지하철 역 관련 기능")
    class AddStationTest {

        @Test
        @DisplayName("지하철 역을 등록할 수 있다.")
        void addStation() {
            subwayService.addStation("잠실역");
            assertTrue(stationRepository.isStationExist("잠실역"));
        }

        @Test
        @DisplayName("역을 삭제할 수 있다.")
        void deleteStation() {
            subwayService.addStation("잠실역");
            assertTrue(stationRepository.isStationExist("잠실역"));
            subwayService.deleteStation("잠실역");
            assertFalse(stationRepository.isStationExist("잠실역"));
        }

        @Test
        @DisplayName("중복된 지하철 역 이름이 등록될 수 없다.")
        void duplicationStation() {
            subwayService.addStation("잠실역");
            assertThrows(IllegalArgumentException.class, () -> subwayService.addStation("잠실역"));
        }

        @Test
        @DisplayName("지하철 역 이름은 2글자 이상이어야 한다.")
        void invalidStationName() {
            assertThrows(IllegalArgumentException.class, () -> subwayService.addStation("짱"));
        }

        @Test
        @DisplayName("지하철 역의 목록을 조회할 수 있다.")
        void getStations() {
            subwayService.addStation("잠실역");
            subwayService.addStation("강남역");
            assertEquals(2, subwayService.getStations().size());
        }
    }

    @Nested
    @DisplayName("지하철 노선 관련 기능")
    class LineServiceTests {

        @Test
        @DisplayName("지하철 노선을 등록할 수 있다.(상행 종점역과 하행 종점역을 입력 받는다.)")
        void addLine() {
            stationRepository.addStation(new Station("잠실역"));
            stationRepository.addStation(new Station("강남역"));
            subwayService.addLine("2호선", "잠실역", "강남역");
            Line line = lineRepository.lines().get(0);
            assertEquals("잠실역", line.getStations().get(0).getName());
            assertEquals("강남역", line.getStations().get(1).getName());
        }

        @Test
        @DisplayName("지하철 노선을 삭제할 수 있다.")
        void deleteLine() {
            stationRepository.addStation(new Station("잠실역"));
            stationRepository.addStation(new Station("강남역"));
            subwayService.addLine("2호선", "잠실역", "강남역");
            subwayService.deleteLine("2호선");
            assertEquals(0, lineRepository.lines().size());
        }

        @Test
        @DisplayName("중복된 지하철 노선 이름이 등록될 수 없다.")
        void duplicateLine() {
            stationRepository.addStation(new Station("잠실역"));
            stationRepository.addStation(new Station("강남역"));
            subwayService.addLine("2호선", "잠실역", "강남역");
            assertThrows(IllegalArgumentException.class, () -> subwayService.addLine("2호선", "구리역", "강남역"));
            assertThrows(IllegalArgumentException.class, () -> subwayService.addLine("2호선", "잠실역", "한국역"));
        }

        @Test
        @DisplayName("지하철 노선의 목록을 조회할 수 있다.")
        void getLines() {
            subwayService.addStation("교대역");
            subwayService.addStation("강남역");
            subwayService.addStation("역삼역");
            subwayService.addLine("2호선", new String[]{"교대역", "강남역", "역삼역"});
            subwayService.addLine("3호선", "교대역", "강남역");
            List<Line> lines = subwayService.getLines();
            assertEquals(2, lines.size());
            assertEquals("2호선", lines.get(0).getName());
            assertEquals("3호선", lines.get(1).getName());
        }

        @Test
        @DisplayName("지하철 노선에 구간을 추가할 수 있다.")
        void addSection() {
            subwayService.addStation("교대역");
            subwayService.addStation("강남역");
            subwayService.addStation("역삼역");
            subwayService.addLine("2호선", "교대역", "강남역");
            subwayService.addSection("2호선", "역삼역", "교대역", "강남역");
            Line line = subwayService.getLines().get(0);
            assertEquals(3, line.getStations().size());
            assertEquals("교대역", line.getStations().get(0).getName());
            assertEquals("역삼역", line.getStations().get(1).getName());
            assertEquals("강남역", line.getStations().get(2).getName());
        }

        @Test
        @DisplayName("노선에 등록된 역을 삭제할 수 있다")
        void removeStation() {
            Station upStation = new Station("상행역");
            Station downStation = new Station("하행역");
            Station midStation = new Station("교대역");

            subwayService.addStation(upStation.getName());
            subwayService.addStation(downStation.getName());
            subwayService.addStation(midStation.getName());

            Line line = new Line("2호선", upStation, downStation);
            line.addSection(midStation, upStation, downStation);
            lineRepository.addLine(line);

            subwayService.removeStation("2호선", "교대역");

            assertEquals(2, line.getStations().size());
            assertFalse(line.getStations().contains(midStation));
        }

        @Test
        @DisplayName("종점을 제거할 경우 다음 역이 종점이 된다")
        void removeEndStation() {
            Station upStation = new Station("상행역");
            Station midStation = new Station("교대역");
            Station downStation = new Station("하행역");

            subwayService.addStation(upStation.getName());
            subwayService.addStation(midStation.getName());
            subwayService.addStation(downStation.getName());

            Line line = new Line("2호선", upStation, downStation);
            line.addSection(midStation, upStation, downStation);
            lineRepository.addLine(line);

            subwayService.removeStation("2호선", "하행역");

            assertEquals(2, line.getStations().size());
            assertFalse(line.getStations().contains(downStation));
            assertEquals(midStation, line.getStations().get(1));
            // System.out.println(line.getStations().get(1).getName());
        }

        @Test
        @DisplayName("노선에 포함된 역이 두개 이하일 때는 역을 제거할 수 없다")
        void cannotRemoveStationWhenTwoOrFewerStations() {
            Station upStation = new Station("상행역");
            Station downStation = new Station("하행역");

            subwayService.addStation(upStation.getName());
            subwayService.addStation(downStation.getName());

            Line line = new Line("2호선", upStation, downStation);
            lineRepository.addLine(line);

            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                subwayService.removeStation("2호선", "상행역");
            });

            assertEquals(ErrorMessage.TOO_FEW_STATIONS, exception.getMessage());
        }
    }
}
