package subway.service.util;

import subway.config.constants.views.Prefixes;

public class LineMakeString {
    String INFO = Prefixes.INFO.getPrefix();
    public String title(final String rail){
        StringBuilder sb= new StringBuilder();
        sb.append(INFO).append(rail).append("\n");
        sb.append(INFO).append("---");
        return sb.toString();
    }

    public String lines(final String name){
        StringBuilder sb = new StringBuilder();
        sb.append(INFO);
        sb.append(name);
        return sb.toString();
    }
}
