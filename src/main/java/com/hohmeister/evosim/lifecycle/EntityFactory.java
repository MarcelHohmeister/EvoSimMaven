package com.hohmeister.evosim.lifecycle;

import com.hohmeister.evosim.components.ComponentManager;
import com.hohmeister.evosim.components.physics.PositionComponent;
import com.hohmeister.evosim.components.urgencies.HydrationComponent;
import com.hohmeister.evosim.lifecycle.blueprint.HydrationRawData;
import com.hohmeister.evosim.lifecycle.blueprint.SpawnRequest;

import java.util.concurrent.ConcurrentLinkedQueue;

public class EntityFactory {
    private final ConcurrentLinkedQueue<SpawnRequest> pending = new ConcurrentLinkedQueue<>();

    private final IDManager idManager;
    private final ComponentManager componentManager;

    public EntityFactory(final IDManager idManager, final ComponentManager componentManager){
        this.idManager = idManager;
        this.componentManager = componentManager;
    }

    // Called by Input-Thread:
    public void enqueue(final SpawnRequest request){
        pending.add(request);
    }

    public void processQueue(){
        SpawnRequest request;

        while((request = pending.poll()) != null){
            spawn(request);
        }
    }

    private void spawn(final SpawnRequest request){
        final int id = idManager.getID();

        componentManager.positionComponents.put(id, new PositionComponent(request.position));

        if(request.hydrationData != null) componentManager.hydrationComponents.put(id, buildHydration(request.hydrationData));
    }

    private HydrationComponent buildHydration(final HydrationRawData data){
        return new HydrationComponent(data.maxHydration(), data.decayPerSecond(), data.awarenessThresholdPercent());
    }
}
