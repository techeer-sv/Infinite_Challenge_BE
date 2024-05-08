package subway.view;

public class AskView {
    private static StringBuilder sb = new StringBuilder();

    public void printMain(){
        sb.append("## 메인 화면\n");
        sb.append("1. 역 관리\n");
        sb.append("2. 노선 관리\n");
        sb.append("3. 구간 관리\n");
        sb.append("4. 지하철 노선도 출력\n");
        sb.append("Q. 종료\n");
        System.out.println(sb.toString());

        sb.setLength(0);
    }

    public void WhatToManage(String target){
        sb.append("## " + target + " 관리 화면\n");
        sb.append("1. "+target + " 등록\n");
        sb.append("2. "+target + " 삭제\n");
        sb.append("3. "+target + " 조회\n");
        sb.append("B. 돌아가기\n");
        System.out.println(sb.toString());
        sb.setLength(0);
    }

    public void Function(){
        sb.append("## 원하는 기능을 선택하세요\n");
        System.out.println(sb.toString());
        sb.setLength(0);
    }

    public void Name(String work, String name){ // 등록 or 삭제
        sb.append("## "+work+"할 " + name + " 이름을 입력하세요\n");
        System.out.println(sb.toString());
        sb.setLength(0);
    }
}
