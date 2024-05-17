package subway.view.util;

import subway.config.constants.views.Indexes;
import subway.config.constants.views.Prefixes;
import subway.config.constants.views.Questions;

public interface Constants {
    static final String SHARP = Prefixes.SHARP.getPrefix();
    static final String INFO = Prefixes.INFO.getPrefix();
    static final Indexes METHOD = Indexes.METHOD;
    static final Questions SEQUENCE = Questions.SEQUENCE;
    static final Questions TARGET = Questions.NAME;
    static final Questions FUNC = Questions.FUNC;
    static final String MAIN = Indexes.MAIN.getRole();
    static final String MAIN_INDEX = Indexes.MAIN.getIndex();

}
