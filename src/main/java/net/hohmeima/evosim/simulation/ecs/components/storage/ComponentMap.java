package net.hohmeima.evosim.simulation.ecs.components.storage;

import java.util.HashMap;
import java.util.Map;

public class ComponentMap<T> implements ComponentStorage
{
	private final Map<Integer, T> map = new HashMap<>();

	public void add(final int id, final T component)
	{
		map.put(id, component);
	}

	public T get(final int id)
	{
		return map.get(id);
	}

	public Iterable<Map.Entry<Integer, T>> entries()
	{
		return map.entrySet();
	}

	@Override
	public void removeEntity(final int id)
	{
		map.remove(id);
	}
}
