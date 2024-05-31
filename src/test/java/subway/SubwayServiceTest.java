package subway;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import subway.domain.Line;
import subway.domain.Station;
import subway.domain.repository.LineRepository;
import subway.domain.repository.StationRepository;
import subway.service.LineService;
import subway.service.StationService;
import subway.service.SubwayService;

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
        LineService lineService = new LineService(lineRepository, stationRepository);
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
    }
}
