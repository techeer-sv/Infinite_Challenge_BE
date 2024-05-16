package subway.controller.controllers;

import subway.service.InitSubwayValues;
import subway.service.LineManager;

public class MapController {
    static LineManager lineManager;
    public MapController(InitSubwayValues manager){
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
