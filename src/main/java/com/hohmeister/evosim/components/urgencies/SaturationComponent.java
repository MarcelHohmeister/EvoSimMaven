package com.hohmeister.evosim.components.urgencies;

import com.hohmeister.evosim.systems.urgencies.ai.UtilAction;

public class SaturationComponent implements UrgencyComponent {
    // Saturation Level
    public double currentSaturation;
    public final double maxSaturation;

    // Saturation Decay
    public final double decayPerSecond;
    public final double awarenessThresholdPercent;

    // Urgency
    private double urgency;

    public SaturationComponent(final double maxSaturation, final double decayPerSecond, final double awarenessThresholdPercent){
        this.maxSaturation = maxSaturation;
        this.currentSaturation = maxSaturation;

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

    @Override
    public UtilAction getAssociatedAction(){
        return UtilAction.EAT;
    }
}
