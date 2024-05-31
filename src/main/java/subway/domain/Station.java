package subway.domain;

public class Station {
    private final String name;

    public Station(String name) {
        if(name == null || name.length() < 2) {
            throw new IllegalArgumentException("[ERROR] 역 이름은 2글자 이상이어야 합니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
