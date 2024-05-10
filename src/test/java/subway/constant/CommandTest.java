package subway.constant;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.ThrowingSupplier;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@SuppressWarnings("NonAsciiCharacters")
class CommandTest {

    @Nested
    class 메인 {

        @ParameterizedTest
        @ValueSource(strings = {"1", "2", "3", "4", "Q"})
        void 존재하는_버튼만_눌러야한다(String input) {
            //given
            //when
            final ThrowingSupplier<MainCommand> supplier = () -> MainCommand.from(input);

            //then
            assertDoesNotThrow(supplier);
        }

        @Test
        void 존재하는_버튼을_입력하면_정상_생성한다() {
            //given
            final var input = "B";

            //when
            final ThrowingCallable throwingCallable = () -> MainCommand.from(input);

            //then
            assertThatThrownBy(throwingCallable).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class 노선 {

        @ParameterizedTest
        @ValueSource(strings = {"1", "2", "3", "B"})
        void 존재하는_버튼만_눌러야한다(String input) {
            //given
            //when
            final ThrowingSupplier<LineCommand> supplier = () -> LineCommand.from(input);

            //then
            assertDoesNotThrow(supplier);
        }

        @Test
        void 존재하는_버튼을_입력하면_정상_생성한다() {
            //given
            final var input = "A";

            //when
            final ThrowingCallable throwingCallable = () -> LineCommand.from(input);

            //then
            assertThatThrownBy(throwingCallable).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class 지하철역 {

        @ParameterizedTest
        @ValueSource(strings = {"1", "2", "3", "B"})
        void 존재하는_버튼만_눌러야한다(String input) {
            //given
            //when
            final ThrowingSupplier<StationCommand> supplier = () -> StationCommand.from(input);

            //then
            assertDoesNotThrow(supplier);
        }

        @Test
        void 존재하는_버튼을_입력하면_정상_생성한다() {
            //given
            final var input = "A";

            //when
            final ThrowingCallable throwingCallable = () -> StationCommand.from(input);

            //then
            assertThatThrownBy(throwingCallable).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class 구간 {

        @ParameterizedTest
        @ValueSource(strings = {"1", "2", "B"})
        void 존재하는_버튼만_눌러야한다(String input) {
            //given
            //when
            final ThrowingSupplier<SectionCommand> supplier = () -> SectionCommand.from(input);

            //then
            assertDoesNotThrow(supplier);
        }

        @Test
        void 존재하는_버튼을_입력하면_정상_생성한다() {
            //given
            final var input = "Q";

            //when
            final ThrowingCallable throwingCallable = () -> SectionCommand.from(input);

            //then
            assertThatThrownBy(throwingCallable).isInstanceOf(IllegalArgumentException.class);
        }
    }
}