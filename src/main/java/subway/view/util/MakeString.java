package subway.view.util;

public class MakeString implements Constants{
    // ## ~~ 화면
    public String showTitle(final String title){
        return getTitle(MAIN, title);
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
        if(target.equals(MAIN)){
            return MAIN_INDEX;
        }

        return METHOD.getIndex(target);
    }
    public String infoMessage(final String work, final String target, final boolean result){
        StringBuilder sb = new StringBuilder();
        sb.append("지하철 ").append(target).append("이 ");
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
