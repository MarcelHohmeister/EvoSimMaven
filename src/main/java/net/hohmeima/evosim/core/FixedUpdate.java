package net.hohmeima.evosim.core;

public class FixedUpdate
{
	private boolean running = true;

	private final static long NS_PER_TICK = 1_000_000_000L / Settings.TARGET_TPS;
	

	public void start()
	{
		while (running)
		{

		}
	}

	public void stop()
	{
		running = false;
	}
}
