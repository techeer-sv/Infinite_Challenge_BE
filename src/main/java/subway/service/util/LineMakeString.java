package subway.service.util;

import subway.config.constants.views.Prefixes;

public class LineMakeString {
    Prefixes INFO = Prefixes.INFO;
    public String title(final String rail){
        StringBuilder sb= new StringBuilder();
        sb.append(INFO.getPrefix()).append(rail).append("\n");
        sb.append(INFO.getPrefix()).append("---");
        return sb.toString();
    }

    public String lines(final String name){
        StringBuilder sb = new StringBuilder();
        sb.append(INFO.getPrefix());
        sb.append(name);
        return sb.toString();
    }
}
