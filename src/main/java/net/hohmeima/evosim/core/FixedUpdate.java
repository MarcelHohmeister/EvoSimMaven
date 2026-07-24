package net.hohmeima.evosim.core;

public class FixedUpdate
{
	private boolean running = true;

	public void start()
	{
		long lastTime = System.nanoTime();
		long accumulator = 0L;

		while (running)
		{
			long now = System.nanoTime();
			long delta = now - lastTime;
			lastTime = now;

			accumulator += delta;

			// Spiral-of-death-Protection: prevents catch-up loops
			// caused by lag spikes
			if (accumulator > Settings.MAX_ACCUMULATOR_NS)
			{
				accumulator = Settings.MAX_ACCUMULATOR_NS;
			}

			while (accumulator >= Settings.NS_PER_TICK)
			{
				tick();
				accumulator -= Settings.NS_PER_TICK;
			}

			// Rest of the time will be available for the UI
			render();
		}
	}

	private void tick()
	{
		// Simulation Step
	}

	private void render()
	{
		// UI Update
	}

	public void stop()
	{
		running = false;
	}
}