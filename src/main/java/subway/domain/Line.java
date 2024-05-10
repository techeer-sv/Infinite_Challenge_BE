package subway.domain;

import java.util.Objects;
import subway.constant.message.ErrorMessage;

public class Line {

    private static final int MIN_NAME_LENGTH = 2;
    private static final String NAME_SUFFIX = "선";
    private final String name;

    public Line(final String name) {
        validateNameSuffix(name);
        validateNameLenght(name);
        this.name = name;
    }

    private void validateNameSuffix(final String input) {
        if (!input.endsWith(NAME_SUFFIX)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PREFIX.toMessage() + "노선은 선으로 끝나야 합니다");
        }
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
