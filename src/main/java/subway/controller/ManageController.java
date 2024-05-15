package subway.controller;

import subway.controller.utils.Constants;
import subway.controller.utils.Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static subway.controller.StationController.subwayException;

public abstract class ManageController implements Controller, Constants {
    protected static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public boolean work(final Controller controller, final String target) {
        ask.WhatToManage(target);
        ask.Function();
        try {
            String command = br.readLine();
            return sendRequest(controller, command);
        } catch (Exception e) {
            subwayException.unexpected();
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
