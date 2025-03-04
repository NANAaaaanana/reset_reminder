package com.nana.games;

import java.util.EnumSet;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import com.nana.enums.RoleEvent;
import com.nana.enums.RoleState;

@Configuration
@EnableStateMachine
public class RoleStateMachineConfig extends EnumStateMachineConfigurerAdapter<RoleState, RoleEvent> {

    @Override
    public void configure(StateMachineConfigurationConfigurer<RoleState, RoleEvent> config) throws Exception {
        config
                .withConfiguration()
                .autoStartup(true);
    }

    @Override
    public void configure(StateMachineStateConfigurer<RoleState, RoleEvent> states) throws Exception {
        states
                .withStates()
                .initial(RoleState.STATE_1)
                .states(EnumSet.allOf(RoleState.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<RoleState, RoleEvent> transitions) throws Exception {
        transitions
                .withExternal()
                .source(RoleState.STATE_1).target(RoleState.STATE_2).event(RoleEvent.WORK)
                .and()
                .withExternal()
                .source(RoleState.STATE_1).target(RoleState.STATE_3).event(RoleEvent.ENTERTAINMENT)
                .and()
                .withExternal()
                .source(RoleState.STATE_2).target(RoleState.STATE_4).event(RoleEvent.WORK)
                .and()
                .withExternal()
                .source(RoleState.STATE_2).target(RoleState.STATE_1).event(RoleEvent.EAT)
                .and()
                .withExternal()
                .source(RoleState.STATE_3).target(RoleState.STATE_1).event(RoleEvent.WORK)
                .and()
                .withExternal()
                .source(RoleState.STATE_4).target(RoleState.STATE_1).event(RoleEvent.ENTERTAINMENT);
    }
}
