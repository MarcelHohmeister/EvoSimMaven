package com.hohmeister.evosim.entities.components.urgencies;

import com.hohmeister.evosim.entities.components.EntityComponent;

public interface UrgencyComponent extends EntityComponent {
    double getUrgency();
    void setUrgency(final double urgency);
}
