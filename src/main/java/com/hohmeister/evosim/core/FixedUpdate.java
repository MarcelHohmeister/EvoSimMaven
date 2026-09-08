package com.hohmeister.evosim.core;

import com.hohmeister.evosim.config.Settings;
import com.hohmeister.evosim.lifecycle.EntityFactory;
import com.hohmeister.evosim.systems.SystemManager;
import com.hohmeister.evosim.ui.Renderer;
import javafx.animation.AnimationTimer;

public class FixedUpdate extends AnimationTimer{
    private static final long NANOS_PER_TICK = (long) (1_000_000_000.0 / Settings.TARGET_TPS);

    private long lastTime = -1;
    private long accumulator = 0;

    private static final long MAX_ACCUMULATED_NANOS = NANOS_PER_TICK * 5;

    private final SystemManager systemManager;
    private final Renderer renderer;
    private final EntityFactory entityFactory;

    public FixedUpdate(final SystemManager systemManager, final Renderer renderer, final EntityFactory entityFactory) {
        this.systemManager = systemManager;
        this.renderer = renderer;
        this.entityFactory = entityFactory;
    }

    @Override
    public void handle(final long now) {
        if(lastTime < 0) {
            lastTime = now;
            return;
        }

        long frameTime = now - lastTime;
        lastTime = now;

        if(frameTime > MAX_ACCUMULATED_NANOS) {
            frameTime = MAX_ACCUMULATED_NANOS;
        }

        accumulator += frameTime;

        while (accumulator >= NANOS_PER_TICK) {
            systemManager.tick(1.0 / Settings.TARGET_TPS);
            entityFactory.processQueue();
            accumulator -= NANOS_PER_TICK;
        }

        //renderer.renderer();
    }
}
