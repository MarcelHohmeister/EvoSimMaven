package net.hohmeima.evosim.core;

public class Settings
{
	//region FixedUpdate
	public final static int TARGET_TPS = 60;
	private final static long NS_PER_TICK = 1_000_000_000L / TARGET_TPS;
	//endregion
}
