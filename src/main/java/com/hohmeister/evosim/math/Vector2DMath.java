package com.hohmeister.evosim.math;

public class Vector2DMath {
    public static Vector2D add(final Vector2D v1, final Vector2D v2){
        return new Vector2D(v1.x() + v2.x(), v1.y() + v2.y());
    }

    public static Vector2D sub(final Vector2D v1, final Vector2D v2){
        return new Vector2D(v1.x() - v2.x(), v1.y() - v2.y());
    }

    public static Vector2D scale(final Vector2D v1, final double factor){
        return new Vector2D(v1.x() * factor, v1.y() * factor);
    }

    public static double len(final Vector2D v1){
        return Math.sqrt(v1.x() * v1.x() + v1.y() * v1.y());
    }

    public static Vector2D norm(final Vector2D v1){
        final double length = len(v1);

        if (length == 0) {
            throw new IllegalArgumentException("Cannot normalize a zero vector.");
        }

        return new Vector2D(v1.x() / length, v1.y() / length);
    }

    public static double dotp(final Vector2D v1, final Vector2D v2){
        return v1.x() * v2.x() + v1.y() * v2.y();
    }

    public static double angle(final Vector2D v1, final Vector2D v2){
        final double lenV1 = len(v1);
        final double lenV2 = len(v2);

        if (lenV1 == 0 || lenV2 == 0) {
            throw new IllegalArgumentException("Cannot calculate the angle of a zero vector.");
        }

        return Math.acos(
                Math.clamp(dotp(v1, v2) / (lenV1 * lenV2), -1, 1)
        );
    }
}