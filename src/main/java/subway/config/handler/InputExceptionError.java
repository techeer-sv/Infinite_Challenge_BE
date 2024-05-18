package subway.config.handler;

import subway.config.constants.views.Prefixes;

public class InputExceptionError extends RuntimeException{
    public enum ErrorMessage{
        PUT_VAILD_VALUE("유효한 범위 내의 명령어를 입력해주세요."),
        PUT_ONLY_VAILD_NUMBER("자연수만 입력 가능합니다."),
        PUT_UNDER_4_OR_Q_VALUE("4 이하 자연수나 Q만 입력 가능합니다."),
        THERE_IS_NO_SUCH_STATION("존재하지 않은 역입니다."),
        THERE_IS_NO_SUCH_LINE("존재하지 않은 노선입니다."),
        THERE_IS_AREADY_THE_SAME_STATION("이미 생성된 역입니다."),
        THERE_IS_AREADY_THE_SAME_LINE("이미 생성된 노선입니다.");

        private final String message;
        private final static String prefix=Prefixes.ERROR.getPrefix();
        ErrorMessage(String message){
            this.message = message;
        }

        public String getMessage() {
            return prefix+message;
        }
    }
}
