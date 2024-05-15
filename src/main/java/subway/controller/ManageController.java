package subway.controller;

import subway.view.AskView;
import subway.view.ResponseView;
import subway.view.util.MakeString;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static subway.controller.StationController.subwayException;

public abstract class ManageController implements Controller, Constants {
    static final AskView ask = new AskView();
    static final ResponseView response = new ResponseView();
    static final MakeString makeString = new MakeString();

    protected static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public boolean work(final Controller controller, final String target) {
        ask.WhatToManage(target);
        ask.Function();
        try {
            String command = br.readLine();
            sendRequest(controller, command);
            return true;
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
