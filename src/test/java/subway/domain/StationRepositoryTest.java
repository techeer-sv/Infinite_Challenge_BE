package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
class StationRepositoryTest {

    private StationRepository stationRepository;

    @BeforeEach
    void 테스트용_객체_주입() {
        stationRepository = new StationRepository();

        stationRepository.save(new Station("인덕원역"));
        stationRepository.save(new Station("평촌역"));
        stationRepository.save(new Station("범계역"));
    }

    @Test
    void 역의_모든_객체를_반환한다() {
        //given
        //when
        final var stations = stationRepository.getAll();

        //then
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(stations).hasSize(3);
            softly.assertThat(stations.get(0)).isEqualTo(new Station("인덕원역"));
            softly.assertThat(stations.get(1)).isEqualTo(new Station("평촌역"));
            softly.assertThat(stations.get(2)).isEqualTo(new Station("범계역"));
        });
    }

    @Test
    void 다른_이름의_역을_저장해야한다() {
        //given
        final var station = new Station("인덕원역");

        //when
        final ThrowingCallable throwingCallable = () -> stationRepository.save(station);

        //then
        assertThatThrownBy(throwingCallable).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 역을_정상적으로_저장한다() {
        //given
        final var station = new Station("과천역");

        //when
        stationRepository.save(station);

        //then
        final var lists = stationRepository.getAll();

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(lists).hasSize(4);
            softly.assertThat(lists.get(3)).isEqualTo(new Station("과천역"));
        });
    }

    @Test
    void 존재하는_역을_삭제해야한다() {
        //given
        final var stationName = "과천역";

        //when
        final ThrowingCallable throwingCallable = () -> stationRepository.delete(stationName);

        //then
        assertThatThrownBy(throwingCallable).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 역을_삭제한다() {
        //given
        final var stationName = "인덕원역";

        //when
        stationRepository.delete(stationName);

        //then
        final var stations = stationRepository.getAll();
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(stations).hasSize(2);
            softly.assertThat(stations).isNotIn(new Station(stationName));
        });
    }

    @Test
    void 존재하는_이름으로_역을_가져와야한다() {
        //given
        final var stationName = "과천역";

        //when
        final ThrowingCallable throwingCallable = () -> stationRepository.getByName(stationName);

        //then
        assertThatThrownBy(throwingCallable).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 이름으로_역을_가져온다() {
        //given
        final var stationName = "인덕원역";

        //when
        final var station = stationRepository.getByName(stationName);

        //then
        assertThat(station).isEqualTo(new Station(stationName));
    }
}