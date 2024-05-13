package subway.view;

import subway.view.util.Constants;

public class ResponseView implements Constants {
    public void printInfo(final String message){
        StringBuilder sb = new StringBuilder();
        sb.append(INFO).append(message);
        System.out.println(sb);
        sb.setLength(0);
    }

    public void printTitle(final String title){
        StringBuilder sb = new StringBuilder();
        sb.append(SHARP).append(title);
        System.out.println(sb);
        sb.setLength(0);
    }
    public void printList(final StringBuilder message){
        System.out.println(message);
    }
}
