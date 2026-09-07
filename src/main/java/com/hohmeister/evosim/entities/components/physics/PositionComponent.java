package com.hohmeister.evosim.entities.components.physics;

import com.hohmeister.evosim.entities.components.EntityComponent;
import com.hohmeister.evosim.math.Vector2D;

public class PositionComponent implements EntityComponent {
    public Vector2D position;

    public PositionComponent(final Vector2D position){
        this.position = position;
    }
}
