package subway.domain;

import java.util.Objects;
import subway.constant.message.ErrorMessage;

public class Line {

    private static final int MIN_NAME_LENGTH = 2;
    private String name;

    public Line(final String name) {
        validateNameLenght(name);
        this.name = name;
    }

    private void validateNameLenght(final String input) {
        if (input.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PREFIX.toMessage() + "이름은 2글자 이상이여야 합니다.");
        }
    }

    public String getName() {
        return name;
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
        final Line line = (Line) o;
        return Objects.equals(getName(), line.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
