package com.me.statemachine;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        PullRequestState state = PullRequestState.Submitted;
        System.out.println(state + " - " + state.responsiblePerson());
        while (state != PullRequestState.Approved) {
            state = state.nextState(random.nextBoolean());
            System.out.println(state + " - " + state.responsiblePerson() );
        }
    }
}
