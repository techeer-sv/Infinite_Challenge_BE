package subway.controller;

public class LineController extends ManageController{
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

    @Override
    public void registerControll() {
        // 노선 등록하기
        //상행성 종점과 하행성 종점 입력
    }

    @Override
    public void register(String station) {
        // 새로운 노선 db 와 연동하여 생성하기
    }

    @Override
    public void delete(String station) {
        // 노선 db 에서 삭제
    }
}
