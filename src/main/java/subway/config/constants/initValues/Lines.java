package subway.config.constants.initValues;

import java.util.Arrays;
import java.util.List;

public enum Lines { // TODO: 해시맵 생각해보기
    LINE_2("2호선", Arrays.asList("교대역", "강남역", "역삼역")),
    LINE_3("3호선", Arrays.asList("교대역", "남부터미널역", "양재역","매봉역")),
    신분당선("신분당선", Arrays.asList("강남역", "양재역", "양재시민의숲역"));
    private String name;
    private List<String> values;
    Lines(String name, List<String> values){
        this.name = name;
        this.values=values;
    }

    public String getName(){
        return this.name;
    }

    public List<String> getValues(){
        return this.values;
    }
}
