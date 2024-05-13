package subway.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
class LineTest {

    @Test
    void 이름의_길이는_2보다_커야한다() {
        //given
        final var name = "선";

        //when
        final ThrowingCallable throwingCallable = () -> new Line(name);

        //then
        assertThatThrownBy(throwingCallable).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름은_선으로_끝나야_합니다() {
        //given
        final var name = "5호선";

        //when
        final ThrowingCallable throwingCallable = () -> new Line(name);

        //then
        assertThatThrownBy(throwingCallable).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름이_일치하는지_확인합니다() {
        //given
        final var lineName = "2호선";
        final var actualLine = new Line(lineName);

        //when
        //then
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(actualLine.isEqualsByName(lineName)).isTrue();
            softly.assertThat(actualLine.isEqualsByName("9호선")).isFalse();
        });
    }
}