package com.hohmeister.evosim.systems.urgencies.ai;

public enum UtilAction {
    FLEE(3),
    DRINK(2),
    EAT(1),
    WANDER(0);

    private final int priority;

    UtilAction(final int priority){
        this.priority = priority;
    }

    public int getPriority(){
        return priority;
    }
}
