package com.hohmeister.evosim.components.urgencies;

import com.hohmeister.evosim.components.EntityComponent;
import com.hohmeister.evosim.systems.urgencies.ai.UtilAction;

public interface UrgencyComponent extends EntityComponent {
    double getUrgency();
    void setUrgency(final double urgency);
    UtilAction getAssociatedAction();
}
