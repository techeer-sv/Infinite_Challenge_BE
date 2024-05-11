package subway.config.constants.views;

public enum Methods {
    REGISTER("등록"),
    DELETE("삭제"),
    READ("조회"),
    PRINT("출력"),
    END("종료"),
    BACK("돌아가기");
    private final String command;
    Methods(String command){
        this.command = command;
    }

    public String getCommand(){
        return command;
    }
}
