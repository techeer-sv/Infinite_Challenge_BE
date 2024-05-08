package subway.controller;

public class SectionController extends ManageController{
    @Override
    public void work() {
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

    }

    @Override
    public void delete() {

    }
}
