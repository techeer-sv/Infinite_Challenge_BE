package subway.controller;

import subway.service.DataManager;
import subway.service.LineManager;

public class MapController {
    static LineManager lineManager;
    MapController(DataManager manager){
        lineManager = manager.getLineManager();
    }
    public void work(){
        printMap();
    }
    public void printMap(){
        System.out.println(lineManager.getStationLines());
    }
}
