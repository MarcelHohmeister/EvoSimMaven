package net.hohmeima.evosim.simulation.ecs.ids;

import java.util.ArrayDeque;

public class IDManager
{
	private final static ArrayDeque<Integer> ids = new ArrayDeque<>();
	private int highestID = 0;

	public int getID()
	{
		return ids.isEmpty() ? highestID++ : ids.pop();
	}

	public void returnID(final int id)
	{
		ids.addLast(id);
	}
}