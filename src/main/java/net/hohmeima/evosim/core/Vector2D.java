package net.hohmeima.evosim.core;

public class Vector2D
{
	private double x;
	private double y;

	public Vector2D(final double x, final double y)
	{
		this.x = x;
		this.y = y;
	}

	public Vector2D add(final Vector2D other)
	{
		this.x += other.x;
		this.y += other.y;
		return this;
	}

	public Vector2D scale(double factor)
	{
		this.x *= factor;
		this.y *= factor;
		return this;
	}

	public double length()
	{
		return Math.hypot(this.x, this.y);
	}

	public Vector2D normalize()
	{
		double len = length();

		if (len != 0)
		{
			this.x /= len;
			this.y /= len;
		}
		return this;
	}

	public double getX()
	{
		return this.x;
	}

	public double getY()
	{
		return this.y;
	}
}
