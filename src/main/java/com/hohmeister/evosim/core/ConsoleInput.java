package com.hohmeister.evosim.core;

import com.hohmeister.evosim.lifecycle.EntityFactory;
import com.hohmeister.evosim.lifecycle.blueprint.HydrationRawData;
import com.hohmeister.evosim.lifecycle.blueprint.SaturationRawData;
import com.hohmeister.evosim.lifecycle.blueprint.SpawnRequest;
import com.hohmeister.evosim.math.Vector2D;

import java.util.Scanner;

public class ConsoleInput {
    private final EntityFactory entityFactory;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleInput(final EntityFactory entityFactory) {
        this.entityFactory = entityFactory;
    }

    public void start() {
        final Thread thread = new Thread(this::run);
        thread.setDaemon(true);
        thread.start();
    }

    private void run() {
        while (true) {
            System.out.println("Neue Entity erstellen (Enter zum Starten, 'q' zum Abbrechen):");
            if (scanner.nextLine().trim().equalsIgnoreCase("q")) {
                continue;
            }

            final SpawnRequest request = new SpawnRequest();
            request.position = askPosition();
            request.hydrationData = askOptional("Hydration hinzufügen? (j/n)", this::askHydration);
            request.saturationData = askOptional("Saturation hinzufügen? (j/n)", this::askSaturation);

            entityFactory.enqueue(request);
            System.out.println("Entity zur Erstellung vorgemerkt.");
        }
    }

    private Vector2D askPosition() {
        final double x = askDouble("Position X:");
        final double y = askDouble("Position Y:");
        return new Vector2D(x, y);
    }

    private HydrationRawData askHydration() {
        final double maxHydration = askDouble("Max Hydration:");
        final double decayPerSecond = askDouble("Decay pro Sekunde:");
        final double awarenessThresholdPercent = askDouble("Awareness Threshold (0-1):");
        return new HydrationRawData(maxHydration, decayPerSecond, awarenessThresholdPercent);
    }

    private SaturationRawData askSaturation() {
        final double maxSaturation = askDouble("Max Saturation:");
        final double decayPerSecond = askDouble("Decay pro Sekunde:");
        final double awarenessThresholdPercent = askDouble("Awareness Threshold (0-1):");
        return new SaturationRawData(maxSaturation, decayPerSecond, awarenessThresholdPercent);
    }

    private <T> T askOptional(final String prompt, final java.util.function.Supplier<T> builder) {
        System.out.println(prompt);
        final String answer = scanner.nextLine().trim();
        return answer.equalsIgnoreCase("j") ? builder.get() : null;
    }

    private double askDouble(final String prompt) {
        while (true) {
            System.out.println(prompt);
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (final NumberFormatException e) {
                System.out.println("Ungültige Zahl, bitte erneut versuchen.");
            }
        }
    }
}