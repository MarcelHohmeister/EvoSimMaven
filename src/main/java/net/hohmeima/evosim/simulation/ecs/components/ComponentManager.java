package net.hohmeima.evosim.simulation.ecs.components;

import net.hohmeima.evosim.simulation.ecs.components.physics.PositionComponent;
import net.hohmeima.evosim.simulation.ecs.components.storage.ComponentMap;
import net.hohmeima.evosim.simulation.ecs.components.storage.ComponentStorage;

import java.util.ArrayList;
import java.util.List;

public class ComponentManager
{
	private final List<ComponentStorage> allComponentMaps = new ArrayList<>();

	public final ComponentMap<PositionComponent> positions;

	public ComponentManager()
	{
		positions = register();
	}

	public void removeEntity(final int id)
	{
		for (ComponentStorage storage : allComponentMaps)
		{
			storage.removeEntity(id);
		}
	}

	private <T> ComponentMap<T> register()
	{
		ComponentMap<T> map = new ComponentMap<>();
		allComponentMaps.add(map);
		return map;
	}
}
