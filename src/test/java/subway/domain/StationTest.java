package subway.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.ThrowingSupplier;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@SuppressWarnings("NonAsciiCharacters")
class StationTest {

    @Test
    void 이름의_길이는_2보다_커야한다() {
        //given
        final var name = "역";

        //when
        final ThrowingCallable throwingCallable = () -> new Station(name);

        //then
        assertThatThrownBy(throwingCallable).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"asdf", "asd역"})
    void 지하철역_이름은_한글만_가능합니다(String input) {
        //given
        //when
        final ThrowingCallable throwingCallable = () -> new Station(input);

        //then
        assertThatThrownBy(throwingCallable).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"인덕원", "과천정부청사"})
    void 지하철역_이름은_역으로_끝나야합니다(String input) {
        //given
        //when
        final ThrowingCallable throwingCallable = () -> new Station(input);

        //then
        assertThatThrownBy(throwingCallable).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름을_정상적으로_입력하면_생성한다() {
        //given
        final var name = "인덕원역";

        //when
        final ThrowingSupplier<Station> supplier = () -> new Station(name);

        //then
        assertDoesNotThrow(supplier);
    }
}