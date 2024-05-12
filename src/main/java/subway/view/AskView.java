package subway.view;

import subway.config.constants.views.*;

public class AskView { // view 가 너무 중구난방인 거 같은데 controller, service 처럼 분할할까.
    private static StringBuilder sb = new StringBuilder();
    static final String SHARP = Prefixes.SHARP.getPrefix();
    static final Methods REGISTER = Methods.등록;
    static final Methods DELETE = Methods.삭제;
    static final Methods READ = Methods.조회;
    static final Methods PRINT = Methods.출력;
    static final Methods END = Methods.종료;
    static final Methods BACK = Methods.돌아가기;
    public void printMain() {
        sb.append(SHARP).append(Titles.MAIN.getTitle());
        sb.append("1. ").append(Titles.STATION.getTitle());
        sb.append("2. ").append(Titles.LINE.getTitle());
        sb.append("3. ").append(Titles.SECTION.getTitle());
        sb.append("4. ").append(Titles.MAP.getTitle());
        sb.append(END.getCommand()+". ").append(END+"\n");
        System.out.println(sb.toString());

        sb.setLength(0);
    }

    public void WhatToManage(String target) {
        sb.append(SHARP + target + " 관리 화면\n");
        sb.append("1. " + target + " 등록\n");
        sb.append("2. " + target + " 삭제\n");
        sb.append("3. " + target + " 조회\n");
//        sb.append(REGISTER.getCommand()+". ").append(target+" ").append(REGISTER+"\n");
//        sb.append(DELETE.getCommand()+". ").append(target+" ").append(DELETE+"\n");
//        sb.append(READ.getCommand()+". ").append(target+" ").append(READ+"\n");
//        sb.append(BACK.getCommand()+". ").append(target+" ").append(BACK+"\n");
        System.out.println(sb.toString());
        sb.setLength(0);
    }

    public void sectionManage() {
        sb.append("## 구간 관리 화면\n");
        sb.append("1. 구간 등록\n");
        sb.append("2. 구간 삭제\n");
        sb.append("B. 돌아가기\n");
        System.out.println(sb.toString());
        sb.setLength(0);
    }

    public void Function() {
        sb.append(SHARP).append(Questions.FUNC.Message());
        System.out.println(sb.toString());
        sb.setLength(0);
    }

    public void Name(String work, String name) { // 등록 or 삭제
        sb.append(SHARP).append(Questions.NAME.Message(work, name));
        System.out.println(sb.toString());
        sb.setLength(0);
    }

    public void orderWhat(String name) { // 등록 or 삭제
        sb.append(SHARP).append(name + "을 입력하세요\n");
        System.out.println(sb.toString());
        sb.setLength(0);
    }

    public void orderWhere() { // 등록 or 삭제
        System.out.println(Questions.SEQUENCE.Message());
    }

}
