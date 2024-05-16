package subway.controller.utils;

import subway.config.handler.SubwayException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public abstract class ClassifyMethods implements Controller, Constants {
    static SubwayException subwayException = new SubwayException();

    public boolean work(final Controller controller, final String target) {
        ask.WhatToManage(target);
        ask.Function();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            String command = br.readLine();
            sendRequest(controller, command);
        } catch (Exception e) {
            subwayException.checkCommand();
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
