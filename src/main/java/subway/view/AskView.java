package subway.view;

import subway.view.util.Constants;
import subway.view.util.MakeString;

public class AskView implements Constants { // TODO: (고민) view 가 너무 중구난방인 거 같은데 controller, service 처럼 분할할까.
    static final MakeString makeString = new MakeString();

    public void manageTarget() {
        System.out.println(makeString.showTitle(MAIN));
        System.out.println(makeString.showIndex(MAIN));
    }

    public void WhatToManage(final String target) {
        System.out.println(makeString.showTitle(target));
        System.out.println(makeString.showIndex(target));
    }

    //"원하는 기능을 선택하세요."
    public void Function() {
        System.out.println(makeString.askFunction());
    }

    //## 등록/삭제할 역/노선을 입력하세요
    public void orderIndex(final String work, final String name) {
        String sentence = makeString.askName(work, name);
        System.out.println(sentence);
    }

    // 역/노선을 입력하세요
    public void orderIndex(final String name) {
        String sentence = makeString.askName(name);
        System.out.println(sentence);
    }

    public void orderIndex() { // 등록 or 삭제
        System.out.println(makeString.askSequence());
    }

}
