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
    public void register() {
        // 새로운 노선 db 와 연동하여 생성하기
    }

    @Override
    public void delete() {
        // 노선 db 에서 삭제
    }
}
