package subway.config.constants.views;

import java.util.Arrays;
import java.util.List;

public enum Indexes {
    MAIN("메인", Arrays.asList("역 관리", "노선 관리", "구간 관리", "지하철 노선도 출력")),
    METHOD("기능", Arrays.asList("등록", "삭제", "조회"));

    private String role;
    private List<String> values;

    Indexes(String role, List<String> values) {
        this.role = role;
        this.values = values;
    }

    public String getRole() {
        return this.role;
    }

    public String getIndex() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.size(); i++) {
            sb.append(i + 1).append(". ");
            sb.append(values.get(i)).append("\n");
        }
        sb.append("Q. 종료\n");
        return sb.toString();
    }

    public String getIndex(String target) {
        int size = values.size();
        if (target.equals("구간")) {
            size = 2;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(i + 1).append(". ");
            sb.append(target).append(" ");
            sb.append(values.get(i)).append("\n");
        }
        sb.append("B. 돌아가기\n");
        return sb.toString();
    }
}
