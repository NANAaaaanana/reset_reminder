package com.nana.games;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Service;

import com.nana.enums.RoleEvent;
import com.nana.enums.RoleState;

@Service
public class RoleGameService {

    @Autowired
    private StateMachine<RoleState, RoleEvent> stateMachine;

    public RoleState getCurrentState() {
        return stateMachine.getState().getId();
    }

    public RoleState performAction(RoleEvent event) {
        stateMachine.sendEvent(event);
        return stateMachine.getState().getId();
    }
}
