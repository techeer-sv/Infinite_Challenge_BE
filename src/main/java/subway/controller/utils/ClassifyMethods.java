package subway.controller.utils;

import subway.config.handler.SubwayException;


public abstract class ClassifyMethods implements Controller, Constants {
    static SubwayException subwayException = new SubwayException();
    static CheckCommand checkCommand =new CheckCommand();

    public boolean work(final Controller controller, final String target, boolean isSection) {
        ask.WhatToManage(target);
        ask.Function();
        String command = method.getUserInput();
        if(checkCommand.isMainCommand(command, isSection)){
            sendRequest(controller, command);
            return true;
        }
        return false;
    }

    // 등록하기
    public boolean sendRequest(final Controller controller, final String command) {
        if (command.equals(REGISTER_COMMAND)) {
            return controller.register();
        }
        if (command.equals(DELETE_COMMAND)) {
            return controller.delete();
        }
        if (command.equals(READ_COMMAND)) {
            return controller.read();
        }
        if (command.equals(BACK_COMMAND)) {
            return true;
        }
        subwayException.notValidCommand();
        return false;
    }
}
