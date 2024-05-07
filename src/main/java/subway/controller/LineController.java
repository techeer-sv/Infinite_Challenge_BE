package subway.controller;

public class LineController extends ManageController{
    public LineController(){}
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

    }

    @Override
    public void register(String station) {

    }

    @Override
    public void delete(String station) {

    }
}
