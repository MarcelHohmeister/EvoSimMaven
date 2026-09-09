package com.hohmeister.evosim.systems.urgencies.ai;

import com.hohmeister.evosim.components.ComponentManager;
import com.hohmeister.evosim.components.EntityComponent;
import com.hohmeister.evosim.components.ai.NavigationComponent;
import com.hohmeister.evosim.components.urgencies.UrgencyComponent;
import com.hohmeister.evosim.systems.Tickable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilAI implements Tickable {
    private final ComponentManager componentManager;

    public UtilAI(final ComponentManager componentManager){
        this.componentManager = componentManager;
    }

    @Override
    public void tick(final double dt) {
        final Map<Integer, List<UrgencyComponent>> urgenciesPerEntity = new HashMap<>();
        componentManager.allComponents.forEach(map -> checkUrgencyMap(map, urgenciesPerEntity));

        chooseFinalAction(urgenciesPerEntity);
    }

    private void checkUrgencyMap(final Map<Integer, ? extends EntityComponent> map, final Map<Integer, List<UrgencyComponent>> urgenciesPerEntity){
        for(final Map.Entry<Integer, ? extends  EntityComponent> entry : map.entrySet()){
            if(entry.getValue() instanceof final UrgencyComponent urgencyComponent){
                urgenciesPerEntity
                        .computeIfAbsent(entry.getKey(), k -> new ArrayList<>())
                        .add(urgencyComponent);
            }
            else{
                return;
            }
        }
    }

    private void chooseFinalAction(final Map<Integer, List<UrgencyComponent>> urgenciesPerEntity){
        for(final Map.Entry<Integer, List<UrgencyComponent>> entry : urgenciesPerEntity.entrySet()){
            final int id = entry.getKey();
            final List<UrgencyComponent> urgenciesForThisEntity = entry.getValue();
            final UtilAction chosenAction = getChosenAction(urgenciesForThisEntity);

            final NavigationComponent navigationComponent = componentManager.navigationComponents.get(id);
            if (navigationComponent != null) {
                navigationComponent.updateChosenAction(chosenAction);
            }
        }
    }

    private static UtilAction getChosenAction(final List<UrgencyComponent> urgenciesForThisEntity) {
        UtilAction chosenAction = UtilAction.WANDER;
        double highestUrgency = -1;

        for(final UrgencyComponent urgencyComponent : urgenciesForThisEntity){
            final double urgency = urgencyComponent.getUrgency();
            final UtilAction action = urgencyComponent.getAssociatedAction();

            if(urgency > highestUrgency
                    || (urgency == highestUrgency && action.getPriority() > chosenAction.getPriority())){
                highestUrgency = urgency;
                chosenAction = action;
            }
        }
        return chosenAction;
    }
}
