package subway.config;

import subway.service.SubwayService;
import subway.util.SubwayUtils;

public class SubwayInitializer {
    private final SubwayService subwayService;

    public SubwayInitializer(SubwayService subwayService) {
        this.subwayService = subwayService;
    }

    public void initialize() {
        initializeStations();
        initializeLines();
    }

    private void initializeStations() {
        SubwayUtils.addStations(subwayService,
                "교대역", "강남역", "역삼역",
                "남부터미널역", "양재역", "양재시민의숲역", "매봉역"
        );
    }

    private void initializeLines() {
        SubwayUtils.addLines(subwayService, new Object[][]{
                {"2호선", new String[]{"교대역", "강남역", "역삼역"}},
                {"3호선", new String[]{"교대역", "남부터미널역", "양재역", "매봉역"}},
                {"신분당선", new String[]{"강남역", "양재역", "양재시민의숲역"}}
        });
    }

}
