package com.hohmeister.evosim.systems;

import java.util.ArrayList;
import java.util.List;

public class SystemManager implements Tickable {
    public final List<Tickable> allSystems = new ArrayList<>();

    public void tick(final double dt) {
        allSystems.forEach(system -> system.tick(dt));
    }
}
