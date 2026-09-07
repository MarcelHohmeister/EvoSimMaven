package com.hohmeister.evosim.entities.components;

import com.hohmeister.evosim.entities.components.physics.PositionComponent;
import com.hohmeister.evosim.entities.components.urgencies.HydrationComponent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ComponentManager {
    public List<HashMap<Integer, ? extends EntityComponent>> allComponents = new ArrayList<>();

    // Physics Components
    public final HashMap<Integer, PositionComponent> positionComponents = newComponentMap();

    // Urgency Components
    public final HashMap<Integer, HydrationComponent> hydrationComponents = newComponentMap();

    public <T extends EntityComponent> HashMap<Integer, T> newComponentMap() {
        final HashMap<Integer, T> newComponent = new HashMap<>();
        allComponents.add(newComponent);
        return newComponent;
    }
}
