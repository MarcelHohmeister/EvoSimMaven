package com.hohmeister.evosim.components.ai;

import com.hohmeister.evosim.components.EntityComponent;
import com.hohmeister.evosim.systems.urgencies.ai.UtilAction;

public class NavigationComponent implements EntityComponent {
    public UtilAction chosenAction;

    public NavigationComponent(final UtilAction chosenAction){
        this.chosenAction = chosenAction;
    }

    public void updateChosenAction(final UtilAction chosenAction){
        this.chosenAction = chosenAction;
    }
}
