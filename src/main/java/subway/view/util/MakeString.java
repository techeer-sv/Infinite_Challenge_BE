package subway.view.util;

import subway.config.constants.views.Indexes;
import subway.config.constants.views.Prefixes;
import subway.config.constants.views.Questions;

public class MakeString {
    static final String SHARP = Prefixes.SHARP.getPrefix();
    static final Indexes MAIN = Indexes.MAIN;
    static final Indexes METHOD = Indexes.METHOD;
    static final Questions SEQUENCE = Questions.SEQUENCE;
    static final Questions TARGET = Questions.NAME;
    static final Questions FUNC = Questions.FUNC;


    // ## ~~ 화면
    public String showTitle(final String title){
        String role = MAIN.getRole();
        return getTitle(role, title);
    }

    public String getTitle(final String role, final String title){
        StringBuilder sb = new StringBuilder();
        if(title.equals(role)){
            sb.append(SHARP).append(title);
            sb.append(" 화면");
            return sb.toString();
        }
        sb.append(SHARP).append(title);
        sb.append("관리 화면");
        return sb.toString();
    }

    public String showIndex(final String target){
        if(target.equals(MAIN.getRole())){
            return MAIN.getIndex();
        }

        return METHOD.getIndex(target);
    }
    public String infoMessage(final String work, final boolean result){
        StringBuilder sb = new StringBuilder();
        sb.append("지하철 역이 "); // 쓸데없이 긴 것 같은데 string 다루는 모듈을 따로 만들까. controller 기능이 잘 안보이는 것 같음
        if(result == true){
            sb.append(work).append("되었습니다.");
        }
        if(result == false){
            sb.append(work).append("되지 않았습니다.");
        }
        return sb.toString();
    }

    // 노선/역이름 을 입력하세요.
    public String askName(final String target){
        return TARGET.Message(target);
    }

    // 등록/삭제할 노선/역이름 을 입력하세요.
    public String askName(final String work, final String name){
        return TARGET.Message(work, name);
    }

    public String askFunction(){
        return FUNC.Message();
    }

    public String askSequence(){
        return SEQUENCE.Message();
    }
}
