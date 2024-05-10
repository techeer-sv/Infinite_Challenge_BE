package subway.domain;

import java.util.Objects;
import java.util.regex.Pattern;
import subway.constant.message.ErrorMessage;

public class Station {

    private final Pattern NAME_PATTERN = Pattern.compile("^[가-힣]+$");
    private static final int MIN_NAME_LENGTH = 2;
    private String name;

    public Station(final String name) {
        validateNameLenght(name);
        validateNameRegex(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateNameLenght(final String input) {
        if (input.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PREFIX.toMessage() + "이름은 2글자 이상이여야 합니다.");
        }
    }

    private void validateNameRegex(final String input) {
        if (!NAME_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PREFIX.toMessage() + "한글만 입력 가능합니다.");
        }
    }

    public boolean isEqualsByName(final String input) {
        return Objects.equals(name, input);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Station station = (Station) o;
        return Objects.equals(getName(), station.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
