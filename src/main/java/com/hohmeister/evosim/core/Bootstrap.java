package com.hohmeister.evosim.core;

import com.hohmeister.evosim.entities.IDManager;
import com.hohmeister.evosim.entities.components.ComponentManager;
import com.hohmeister.evosim.systems.EntityDeathSystem;
import com.hohmeister.evosim.systems.SystemManager;
import com.hohmeister.evosim.systems.urgencies.HydrationSystem;
import com.hohmeister.evosim.ui.Renderer;

@SuppressWarnings("FieldCanBeLocal")
public class Bootstrap {
    // ECS Structure
    private final SystemManager systemManager = new SystemManager();
    private final ComponentManager componentManager = new ComponentManager();
    private final IDManager idManager = new IDManager();
    private final EntityDeathSystem entityDeathSystem = new EntityDeathSystem(idManager, componentManager);

    // Rendering
    private final Renderer renderer = new Renderer();

    // Game loop
    private final FixedUpdate fixedUpdate;

    public Bootstrap() {
        systemManager.allSystems.add(new HydrationSystem(componentManager, entityDeathSystem));
        fixedUpdate = new FixedUpdate(systemManager, renderer);
    }

    public void run(){
        fixedUpdate.start();
    }
}
