package com.hohmeister.evosim.systems;

import com.hohmeister.evosim.entities.IDManager;
import com.hohmeister.evosim.entities.components.ComponentManager;
import com.hohmeister.evosim.entities.components.EntityComponent;

import java.util.HashMap;

public class EntityDeathSystem {
    private final IDManager idManager;
    private final ComponentManager componentManager;

    public EntityDeathSystem(final IDManager idManager, final ComponentManager componentManager){
        this.idManager = idManager;
        this.componentManager = componentManager;
    }

    public void kill(final int id){
        for(final HashMap<Integer, ? extends EntityComponent> componentMap : componentManager.allComponents){
            componentMap.remove(id);
        }

        idManager.returnID(id);
    }
}
