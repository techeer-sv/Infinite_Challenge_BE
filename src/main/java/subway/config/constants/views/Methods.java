package subway.config.constants.views;

public enum Methods {
    등록("1"),
    삭제("2"),
    조회("3"),
    출력("4"),
    종료("Q"),
    돌아가기("B");
    private final String command;
    Methods(String command){
        this.command = command;
    }

    public String getCommand(){
        return command;
    }
}
