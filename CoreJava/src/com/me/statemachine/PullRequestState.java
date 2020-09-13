package com.me.statemachine;

public enum PullRequestState {

    Submitted {
        @Override
        public PullRequestState nextState(boolean val) {
            return val? Escalated : Approved;
        }

        @Override
        public String responsiblePerson() {
            return "Programmer";
        }
    },
    Escalated {
        @Override
        public PullRequestState nextState(boolean val) {
            return Approved;
        }

        @Override
        public String responsiblePerson() {
            return "Squad Lead";
        }
    },
    Approved {
        @Override
        public PullRequestState nextState(boolean val) {
            return this;
        }

        @Override
        public String responsiblePerson() {
            return "Another programmer";
        }
    };

    public abstract PullRequestState nextState(boolean val);
    public abstract String responsiblePerson();
}
