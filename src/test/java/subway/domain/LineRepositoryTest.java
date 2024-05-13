package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
class LineRepositoryTest {

    private LineRepository lineRepository;

    @BeforeEach
    void 테스트용_객체_주입() {
        lineRepository = new LineRepository();

        lineRepository.save(new Line("1호선"));
        lineRepository.save(new Line("2호선"));
        lineRepository.save(new Line("3호선"));
    }

    @Test
    void 노선의_모든_객체를_반환한다() {
        //given
        //when
        final var lists = lineRepository.getAll();

        //then
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(lists).hasSize(3);
            softly.assertThat(lists.get(0)).isEqualTo(new Line("1호선"));
            softly.assertThat(lists.get(1)).isEqualTo(new Line("2호선"));
            softly.assertThat(lists.get(2)).isEqualTo(new Line("3호선"));
        });
    }

    @Test
    void 다른_이름의_노선을_저장해야한다() {
        //given
        final var line = new Line("1호선");

        //when
        final ThrowingCallable throwingCallable = () -> lineRepository.save(line);

        //then
        assertThatThrownBy(throwingCallable).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 노선을_정상적으로_저장한다() {
        //given
        final var line = new Line("4호선");

        //when
        lineRepository.save(line);

        //then
        final var lists = lineRepository.getAll();

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(lists).hasSize(4);
            softly.assertThat(lists.get(3)).isEqualTo(new Line("4호선"));
        });
    }

    @Test
    void 존재하는_노선을_삭제해야한다() {
        //given
        final var lineName = "5호선";

        //when
        final ThrowingCallable throwingCallable = () -> lineRepository.delete(lineName);

        //then
        assertThatThrownBy(throwingCallable).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 노선을_삭제한다() {
        //given
        final var lineName = "1호선";

        //when
        lineRepository.delete(lineName);

        //then
        final var lines = lineRepository.getAll();
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(lines).hasSize(2);
            softly.assertThat(lines).isNotIn(new Line(lineName));
        });
    }

    @Test
    void 존재하는_이름으로_노선을_가져와야한다() {
        //given
        final var lineName = "5호선";

        //when
        final ThrowingCallable throwingCallable = () -> lineRepository.getByName(lineName);

        //then
        assertThatThrownBy(throwingCallable).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 이름으로_노선을_가져온다() {
        //given
        final var lineName = "1호선";

        //when
        final var line = lineRepository.getByName(lineName);

        //then
        assertThat(line).isEqualTo(new Line(lineName));
    }
}