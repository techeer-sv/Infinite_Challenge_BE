package subway;

import subway.domain.*;

public class Initializer {

    public static void initializeSubwaySystem() {
        // Register stations
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
        StationRepository.addStation(new Station("매봉역"));

        // Register lines and add stations to them
        Line line2 = new Line("2호선");
        line2.addStation(StationRepository.getStation("교대역"));
        line2.addStation(StationRepository.getStation("강남역"));
        line2.addStation(StationRepository.getStation("역삼역"));
        LineRepository.addLine(line2);

        Line line3 = new Line("3호선");
        line3.addStation(StationRepository.getStation("교대역"));
        line3.addStation(StationRepository.getStation("남부터미널역"));
        line3.addStation(StationRepository.getStation("양재역"));
        line3.addStation(StationRepository.getStation("매봉역"));
        LineRepository.addLine(line3);

        Line sinbundang = new Line("신분당선");
        sinbundang.addStation(StationRepository.getStation("강남역"));
        sinbundang.addStation(StationRepository.getStation("양재역"));
        sinbundang.addStation(StationRepository.getStation("양재시민의숲역"));
        LineRepository.addLine(sinbundang);
    }

}
