package com.hohmeister.evosim.entities.components.urgencies;

import com.hohmeister.evosim.entities.components.EntityComponent;

public class HydrationComponent implements EntityComponent {
    // Hydration Level
    public double currentHydration;
    public final double maxHydration;

    // Hydration Decay
    public final double decayPerSecond;
    public final double awarenessThresholdPercent;

    // Urgency
    public double urgency;

    public HydrationComponent(final double maxHydration, final double decayPerSecond, final double awarenessThresholdPercent){
        this.maxHydration = maxHydration;
        this.currentHydration = maxHydration;

        this.decayPerSecond = decayPerSecond;
        this.awarenessThresholdPercent = awarenessThresholdPercent;
    }
}
