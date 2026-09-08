package com.hohmeister.evosim.entities.components.urgencies;

public class HydrationComponent implements UrgencyComponent {
    // Hydration Level
    public double currentHydration;
    public final double maxHydration;

    // Hydration Decay
    public final double decayPerSecond;
    public final double awarenessThresholdPercent;

    // Urgency
    private double urgency;

    public HydrationComponent(final double maxHydration, final double decayPerSecond, final double awarenessThresholdPercent){
        this.maxHydration = maxHydration;
        this.currentHydration = maxHydration;

        this.decayPerSecond = decayPerSecond;
        this.awarenessThresholdPercent = awarenessThresholdPercent;
    }

    @Override
    public void setUrgency(final double urgency){
        this.urgency = urgency;
    }

    @Override
    public double getUrgency(){
        return urgency;
    }
}
