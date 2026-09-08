package com.hohmeister.evosim.components.urgencies;

import com.hohmeister.evosim.components.EntityComponent;

public interface UrgencyComponent extends EntityComponent {
    double getUrgency();
    void setUrgency(final double urgency);
}
