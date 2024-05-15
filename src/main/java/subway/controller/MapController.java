package subway.controller;

import subway.service.InitManager;
import subway.service.LineManager;

public class MapController {
    static LineManager lineManager;
    MapController(InitManager manager){
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
