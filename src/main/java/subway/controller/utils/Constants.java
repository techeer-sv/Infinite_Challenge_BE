package subway.controller.utils;

import subway.config.constants.views.Methods;
import subway.config.constants.Targets;
import subway.view.AskView;
import subway.view.ResponseView;
import subway.view.util.MakeString;

public interface Constants {
    static final String REGISTER_COMMAND = Methods.등록.getCommand();
    static final String DELETE_COMMAND = Methods.삭제.getCommand();
    static final String READ_COMMAND = Methods.조회.getCommand();
    static final String BACK_COMMAND = Methods.돌아가기.getCommand();

    static final String REGISTER = Methods.등록.toString();
    static final String DELETE = Methods.삭제.toString();

    static final String STATION = Targets.STATION.getTarget();
    static final String LINE = Targets.LINE.getTarget();
    static final String UPPER = Targets.UPPER.getTarget();
    static final String BOTTOM = Targets.BOTTOM.getTarget();
    static final String SECTION = Targets.SECTION.getTarget();

    static final int STATION_COMMAND = Targets.STATION.getCommand();
    static final int LINE_COMMAND = Targets.LINE.getCommand();
    static final int SECTION_COMMAND = Targets.SECTION.getCommand();
    static final int MAP_COMMAND = Targets.MAP.getCommand();

    static final AskView ask = new AskView();
    static final ResponseView response = new ResponseView();
    static final MakeString makeString = new MakeString();

    static SetPrint setPrint = new SetPrint();
}
