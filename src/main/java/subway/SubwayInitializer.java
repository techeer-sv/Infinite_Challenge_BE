package subway;

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
        subwayService.addStation("교대역");
        subwayService.addStation("강남역");
        subwayService.addStation("역삼역");
        subwayService.addStation("남부터미널역");
        subwayService.addStation("양재역");
        subwayService.addStation("양재시민의숲역");
        subwayService.addStation("매봉역");
    }

    private void initializeLines() {
        subwayService.addLine("2호선", new String[]{"교대역", "강남역", "역삼역"});
        subwayService.addLine("3호선", new String[]{"교대역", "남부터미널역", "양재역", "매봉역"});
        subwayService.addLine("신분당선", new String[]{"강남역", "양재역", "양재시민의숲역"});
    }

}
