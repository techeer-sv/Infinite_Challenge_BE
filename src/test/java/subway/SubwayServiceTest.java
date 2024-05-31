package subway;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import subway.domain.LineRepository;
import subway.domain.StationRepository;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SubwayServiceTest {
    SubwayService subwayService;

    @BeforeEach
    void setUp() {
        subwayService = new SubwayService();
    }

    @Nested
    @DisplayName("역 등록 테스트")
    class AddStationTest {

        @Test
        @DisplayName("새로운 역을 등록")
        void addStation() {
            subwayService.addStation("잠실역");
            assertTrue(StationRepository.isStationExist("잠실역"));
        }

        @Test
        @DisplayName("중복된 역 검증")
        void duplicationStation() {
            subwayService.addStation("잠실역");
            assertThrows(IllegalArgumentException.class, () -> subwayService.addStation("잠실역"));
        }

        @Test
        @DisplayName("역 이름은 2글자 이상이어야 한다.")
        void invalidStationName() {
            assertThrows(IllegalArgumentException.class, () -> subwayService.addStation("짱"));
        }
    }
}
