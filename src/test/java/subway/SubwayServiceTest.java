package subway;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import subway.domain.LineRepository;
import subway.domain.StationRepository;

import static org.junit.jupiter.api.Assertions.*;

public class SubwayServiceTest {
    SubwayService subwayService;

    @BeforeEach
    void setUp() {
        subwayService = new SubwayService();
        StationRepository.clear();
        LineRepository.clear();
    }

    @Nested
    @DisplayName("지하철 역 관련 기능")
    class AddStationTest {

        @Test
        @DisplayName("지하철 역을 등록할 수 있다.")
        void addStation() {
            subwayService.addStation("잠실역");
            assertTrue(StationRepository.isStationExist("잠실역"));
        }

        @Test
        @DisplayName("역을 삭제할 수 있다.")
        void deleteStation() {
            subwayService.addStation("잠실역");
            assertTrue(StationRepository.isStationExist("잠실역"));
            subwayService.deleteStation("잠실역");
            assertFalse(StationRepository.isStationExist("잠실역"));
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
}
