package subway.controller;

import subway.view.AskView;
import subway.view.ResponseView;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static subway.controller.StationController.subwayException;

public abstract class ManageController implements Controller, Constants {
    final static AskView ask = new AskView();
    final static ResponseView response = new ResponseView();

    protected static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void work(Controller controller, String target) {
        ask.WhatToManage(target);
        ask.Function();
        try {
            String command = br.readLine();
            sendRequest(controller, command);
        } catch (Exception e) {
            subwayException.unexpected();
        }
    }

    // 등록하기
    public void sendRequest(final Controller controller, final String command) {
        if (command.equals(REGISTER_COMMAND)) {
            controller.register();
            return;
        }
        if (command.equals(DELETE_COMMAND)) {
            controller.delete();
            return;
        }
        if (command.equals(READ_COMMAND)) {
            controller.read();
            return;
        }
        if (command.equals(BACK_COMMAND)) {
            return;
        }
        subwayException.notValidCommand();
    }
}
