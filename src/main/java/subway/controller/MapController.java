package subway.controller;

import subway.service.InitSubwayValues;
import subway.service.LineManager;

public class MapController {
    static LineManager lineManager;
    MapController(InitSubwayValues manager){
        lineManager = manager.getLineManager();
    }
    public boolean work(){
        printMap();
        return true;
    }
    public void printMap(){
        System.out.println(lineManager.getStationLines());
    }
}
