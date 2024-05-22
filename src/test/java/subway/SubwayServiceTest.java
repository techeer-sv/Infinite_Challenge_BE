package subway;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SubwayServiceTest {

    @Nested
    @DisplayName("SubwayService Initialization")
    class SubwayService_Init {
        SubwayService subwayService;

        @BeforeEach
        void setUp() {
            subwayService = new SubwayService();
        }

        @Test
        @DisplayName("지하철 노선도 초기화")
        void initSubwayLine() {
            subwayService.initSubwayLine();

            assertAll(
                    () -> assertEquals(Arrays.asList("교대역", "강남역", "역삼역"), subwayService.getStations("2호선")),
                    () -> assertEquals(Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역"), subwayService.getStations("3호선")),
                    () -> assertEquals(Arrays.asList("강남역", "양재역", "양재시민의숲역"), subwayService.getStations("신분당선"))
            );
        }
    }
}
