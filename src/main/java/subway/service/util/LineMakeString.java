package subway.service.util;

import subway.config.constants.views.Prefixes;

public class LineMakeString {
    Prefixes INFO = Prefixes.INFO;
    public String title(String rail){
        StringBuilder sb= new StringBuilder();
        sb.append(INFO).append(rail).append("\n");
        sb.append(INFO).append("---");
        return sb.toString();
    }

    public String lines(String name){
        StringBuilder sb = new StringBuilder();
        sb.append(INFO);
        sb.append(name);
        return sb.toString();
    }
}
