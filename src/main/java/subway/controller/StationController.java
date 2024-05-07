package subway.controller;

public class StationController extends ManageController{
    @Override
    public void work(){
        ask.Function();
        try{
            String command = br.readLine();
            // command 내용 확인하고 맞는 처리와 연결
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void registerControll(){
        ask.Name("등록", "역");
        try{
            String station = br.readLine();
            register(station);
            // "지하철 역이 등록되었습니다." 출력
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void register(String station){
        // db 접근해서 데이터 삽입하는 서비스와 연결
    }

    public void delete(String station){
        // db 접근해서 데이터 삭제하는 서비스와 연결
    }

    public void requestStations() throws Exception{
        // 역 목록을 출력하는 서비스 코드
    }

    // 되돌아가
    public void goBack(){
        return;
    }
}
