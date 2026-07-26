package net.hohmeima.evosim.simulation.ecs.systems;

import java.util.ArrayList;
import java.util.List;

public class SimulationManager
{
	private final List<SimSystem> allSystem = new ArrayList<>();

	public void tick()
	{
		for (final SimSystem system : allSystem)
		{
			system.tick();
		}
	}
}
