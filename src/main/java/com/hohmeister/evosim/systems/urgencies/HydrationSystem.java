package com.hohmeister.evosim.systems.urgencies;

import com.hohmeister.evosim.entities.components.ComponentManager;
import com.hohmeister.evosim.entities.components.urgencies.HydrationComponent;
import com.hohmeister.evosim.systems.Tickable;

import java.util.Map;

public class HydrationSystem implements Tickable {
    public void tick(final double dt){
        // Step 1: Iterate over each Component
        for(Map.Entry<Integer, HydrationComponent> entry : componentManager.hydrationComponents.entrySet()){
            final int id = entry.getKey();
            final HydrationComponent component = entry.getValue();

            // For every Component entry:
            // Step 2: currentHydration - decayPerSecond * dt
            component.currentHydration = Math.max(0, component.currentHydration - component.decayPerSecond * dt);

            // Step 3: check if dead
            if(component.currentHydration <= 0){
                // kill Entity

                continue;
            }

            // Step 4: if awarenessThresholdPercent does NOT hit -> Write Urgency 0
            final double hydrationPercent = component.currentHydration / component.maxHydration;

            if(hydrationPercent >= component.awarenessThresholdPercent){
                component.urgency = 0;
            }
            // Step 5: if awarenessUrgency Hits: Calculate Urgency (closer to 0 = higherUrgency)
            else{
                component.urgency = Math.pow(1 - (hydrationPercent / component.awarenessThresholdPercent), 2);
            }
        }
    }

    private final ComponentManager componentManager;

    public HydrationSystem(final ComponentManager componentManager){
        this.componentManager = componentManager;
    }
}
