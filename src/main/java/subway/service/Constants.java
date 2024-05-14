package subway.service;

import subway.config.handler.SubwayException;
import subway.domain.LineRepository;
import subway.domain.StationRepository;

public interface Constants {
    static final LineRepository lineRepo = new LineRepository();
    static final StationRepository stationRepo = new StationRepository();

    static final StationManager stationManager = new StationManager();
    static final SectionManager sectionManager = new SectionManager();
    static final LineManager lineManager = new LineManager();

    static final SubwayException subwayException = new SubwayException();

}
