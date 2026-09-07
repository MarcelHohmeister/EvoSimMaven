package com.hohmeister.evosim.entities.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ComponentManager {
    public List<HashMap<Integer, ? extends EntityComponent>> allComponents = new ArrayList<>();

    // Add Component
    //public final HashMap<Integer, HydrationComponent> hydrationComponents = newComponent();

    public <T extends EntityComponent> HashMap<Integer, T> newComponent() {
        final HashMap<Integer, T> newComponent = new HashMap<>();
        allComponents.add(newComponent);
        return newComponent;
    }
}
