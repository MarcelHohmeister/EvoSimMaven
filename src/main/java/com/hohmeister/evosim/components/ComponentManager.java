package com.hohmeister.evosim.components;

import com.hohmeister.evosim.components.ai.NavigationComponent;
import com.hohmeister.evosim.components.physics.PositionComponent;
import com.hohmeister.evosim.components.urgencies.HydrationComponent;
import com.hohmeister.evosim.components.urgencies.SaturationComponent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ComponentManager {
    public List<HashMap<Integer, ? extends EntityComponent>> allComponents = new ArrayList<>();

    // Physics Components
    public final HashMap<Integer, PositionComponent> positionComponents = newComponentMap();

    // Urgency Components
    public final HashMap<Integer, HydrationComponent> hydrationComponents = newComponentMap();
    public final HashMap<Integer, SaturationComponent> saturationComponents = newComponentMap();

    // AI Components
    public final HashMap<Integer, NavigationComponent> navigationComponents = newComponentMap();

    public <T extends EntityComponent> HashMap<Integer, T> newComponentMap() {
        final HashMap<Integer, T> newComponent = new HashMap<>();
        allComponents.add(newComponent);
        return newComponent;
    }
}
