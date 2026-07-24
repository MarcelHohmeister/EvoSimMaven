package net.hohmeima.evosim.core;

public class Settings
{
	//region FixedUpdate
	public final static int TARGET_TPS = 60;
	public final static long NS_PER_TICK = 1_000_000_000L / TARGET_TPS;
	public final static long MAX_ACCUMULATED_TICKS = 5;
	public final static long MAX_ACCUMULATOR_NS = NS_PER_TICK * MAX_ACCUMULATED_TICKS;
	//endregion
}
