package com.hohmeister.evosim.systems.urgencies;

import com.hohmeister.evosim.entities.components.ComponentManager;
import com.hohmeister.evosim.entities.components.urgencies.HydrationComponent;
import com.hohmeister.evosim.systems.EntityDeathSystem;
import com.hohmeister.evosim.systems.Tickable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HydrationSystem implements Tickable {
    public void tick(final double dt){
        final List<Integer> toKill = new ArrayList<>();

        // Step 1: Iterate over each Component
        for(final Map.Entry<Integer, HydrationComponent> entry : componentManager.hydrationComponents.entrySet()){
            final int id = entry.getKey();
            final HydrationComponent component = entry.getValue();

            // For every Component entry:
            // Step 2: currentHydration - decayPerSecond * dt
            component.currentHydration = Math.max(0, component.currentHydration - component.decayPerSecond * dt);

            // Step 3: check if dead
            if(component.currentHydration <= 0){
                // kill Entity
                toKill.add(id);
                continue;
            }

            // Step 4: if awarenessThresholdPercent does NOT hit -> Write Urgency 0
            final double hydrationPercent = component.currentHydration / component.maxHydration;

            if(hydrationPercent >= component.awarenessThresholdPercent){
                component.setUrgency(0);
            }
            // Step 5: if awarenessUrgency Hits: Calculate Urgency (closer to 0 = higherUrgency)
            else{
                component.setUrgency(
                        Math.pow(1 - (hydrationPercent / component.awarenessThresholdPercent), 2)
                );
            }
        }

        for(final int id : toKill){
            entityDeathSystem.kill(id);
        }
    }

    private final ComponentManager componentManager;
    private final EntityDeathSystem entityDeathSystem;

    public HydrationSystem(final ComponentManager componentManager, final EntityDeathSystem entityDeathSystem){
        this.componentManager = componentManager;
        this.entityDeathSystem = entityDeathSystem;
    }
}
