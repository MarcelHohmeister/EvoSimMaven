package net.hohmeima.simulation.ecs.ids;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IDManagerTest
{
	IDManager idManager = new IDManager();

	@Test
	public void testIdSystem()
	{
		int id0 = idManager.getID();
		assertEquals(0, id0);

		int id1 = idManager.getID();
		assertEquals(1, id1);

		idManager.returnID(id0);

		int id2 = idManager.getID();
		assertEquals(0, id2);

		int id3 = idManager.getID();
		assertEquals(2, id3);
	}
}