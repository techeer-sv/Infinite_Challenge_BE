package subway.view;

public class ResponseView {
    static StringBuilder sb = new StringBuilder();
    public void printInfo(String message){
        sb.append("[INFO] ").append(message);
        System.out.println(sb);
        sb.setLength(0);
    }

    public void printTitle(String title){
        sb.append("### ").append(title);
        System.out.println(sb);
        sb.setLength(0);
    }
    public void printList(StringBuilder message){
        System.out.println(message);
    }
}
