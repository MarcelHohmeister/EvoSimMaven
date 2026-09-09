package com.hohmeister.evosim.systems.urgencies;

import com.hohmeister.evosim.components.ComponentManager;
import com.hohmeister.evosim.components.urgencies.SaturationComponent;
import com.hohmeister.evosim.lifecycle.EntityDeathSystem;
import com.hohmeister.evosim.systems.Tickable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SaturationSystem implements Tickable {
    public void tick(final double dt){
        final List<Integer> toKill = new ArrayList<>();

        // Step 1: Iterate over each Component
        for(final Map.Entry<Integer, SaturationComponent> entry : componentManager.saturationComponents.entrySet()){
            final int id = entry.getKey();
            final SaturationComponent component = entry.getValue();

            // For every Component entry:
            // Step 2: currentSaturation - decayPerSecond * dt
            // TODO: add temporary removed * dt
            component.currentSaturation = Math.max(0, component.currentSaturation - component.decayPerSecond);

            // Step 3: check if dead
            if(component.currentSaturation <= 0){
                // kill Entity
                toKill.add(id);
                continue;
            }

            // Step 4: if awarenessThresholdPercent does NOT hit -> Write Urgency 0
            final double saturationPercent = component.currentSaturation / component.maxSaturation;

            if(saturationPercent >= component.awarenessThresholdPercent){
                component.setUrgency(0);
            }
            // Step 5: if awarenessUrgency Hits: Calculate Urgency (closer to 0 = higherUrgency)
            else{
                component.setUrgency(1 - (saturationPercent / component.awarenessThresholdPercent));
            }
        }

        for(final int id : toKill){
            entityDeathSystem.kill(id);
        }
    }

    private final ComponentManager componentManager;
    private final EntityDeathSystem entityDeathSystem;

    public SaturationSystem(final ComponentManager componentManager, final EntityDeathSystem entityDeathSystem){
        this.componentManager = componentManager;
        this.entityDeathSystem = entityDeathSystem;
    }
}
