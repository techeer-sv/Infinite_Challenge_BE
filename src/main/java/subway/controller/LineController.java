package subway.controller;

import subway.config.handler.SubwayException;
import subway.service.InitManager;
import subway.service.LineManager;

public class LineController extends ManageController{
    static LineManager lineManager;
    private static SubwayException subwayException;
    public LineController(final InitManager manager){
        lineManager = manager.getLineManager();
        subwayException = manager.getSubwayException();
    }

    @Override
    public void register() {
        String command = REGISTER;
        // 새로운 노선 db 와 연동하여 생성하기
        ask.Name(command, LINE);
        try{
            String line = br.readLine();
            boolean result = lineManager.isValid(line);
            if(result!= true) return ;

            ask.Name(command, UPPER);
            String upper = br.readLine();
            ask.Name(command, BOTTOM);
            String bottom = br.readLine();

            lineManager.setStations(line, upper, bottom);
            infoMessage(command, result);
        }catch (Exception e){
            e.printStackTrace();
            subwayException.unexpected();
        }
    }

    public void infoMessage(final String work, final boolean result){
        StringBuilder sb = new StringBuilder();
        sb.append("노선이 ");
        if(result == true){
            sb.append(work).append("되었습니다.");
        }
        if(result == false){
            sb.append(work).append("되지 않았습니다.");
        }
        String message = sb.toString();
        response.printInfo(message);
        sb.setLength(0);
    }

    @Override
    public void delete() {
        // 노선 db 에서 삭제
        ask.Name(DELETE, LINE);
        try{
            String command = br.readLine();
            boolean result = lineManager.delete(command);
            infoMessage(DELETE, result);
        }catch (Exception e){
            subwayException.unexpected();
        }
    }

    public void read(){
        response.printTitle("지하철 노선도");
        StringBuilder list = lineManager.read();
        response.printList(list);
    }
}
