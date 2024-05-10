package subway.config.constants.initValues;

public class StationNames {
//    // 해당 자료형을 컨트롤할 수 잇는 코드를 추출할까
//    List<Line> train2 = new LinkedList<>();
//    List<Line> train3 = new LinkedList<>();
//    List<Line> trainSuIn = new LinkedList<>();
    private static final String[] stations = new String []{"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};

    public String[] getNames() {
        return stations;
    }
}
