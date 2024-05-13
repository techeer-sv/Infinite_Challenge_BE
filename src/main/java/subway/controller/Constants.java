package subway.controller;

import subway.config.constants.views.Methods;
import subway.config.constants.views.Targets;

public interface Constants {
    static final String REGISTER_COMMAND = Methods.등록.getCommand();
    static final String DELETE_COMMAND = Methods.삭제.getCommand();
    static final String READ_COMMAND = Methods.조회.getCommand();
    static final String BACK_COMMAND = Methods.돌아가기.getCommand();

    static final String REGISTER = Methods.등록.toString();
    static final String DELETE = Methods.삭제.toString();
    static final String READ = Methods.조회.toString();
    static final String BACK = Methods.돌아가기.toString();

    static final String STATION = Targets.STATION.getTarget();
    static final String LINE = Targets.LINE.getTarget();
    static final String UPPER = Targets.UPPER.getTarget();
    static final String BOTTOM = Targets.BOTTOM.getTarget();
}
