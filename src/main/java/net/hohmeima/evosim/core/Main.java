package net.hohmeima.evosim.core;

public class Main
{
	private final static FixedUpdate fixedUpdate = new FixedUpdate();

	public static void main(String[] args)
	{
		fixedUpdate.start();
	}
}

/*
 * Simulation Tick Pipeline
 *
 * Ein Tick stellt einen abgeschlossenen Wahrnehmungs-
 * Entscheidungs- und Ausführungszyklus dar.
 *
 * 1. Perception System
 *    - Ermittelt sichtbare Entities und Objekte im Umfeld.
 *    - Memory Decay wird auf alle Erinnerungen angewendet
 *    - Aktualisiert Memory Components:
 *        - Alle Sichtbaren Objekte auf 100% Accuracy setzen
 *          (Frage: Wie handhabe ich "Verbrauchsgüter (z.B. Beerenbusch)")
 *
 *
 * 2. Needs System
 *    - Aktualisiert interne Zustände:
 *        - Hunger
 *        - Durst
 *        - Angst
 *    - Bewertet aktuelle Bedürfnisse und Dringlichkeiten.
 *
 *
 * 3. AI System
 *    - Wertet alle aktuellen Informationen aus:
 *        - Needs
 *        - Memory
 *        - Perception
 *
 *    - Berechnet mögliche Aktionen.
 *    - Die Aktion mit dem höchsten Wert gewinnt den Tick.
 *
 *    Beispiele:
 *        - FLEE
 *        - DRINK
 *        - EAT
 *        - WANDER
 *        - SEARCH
 *
 *
 * 4. Action / Movement System
 *    - Setzt Ziel (je nach Aktion - DRINK bsp. über Auswertung der Memories oder random)
 *      (Frage: Gruppenintelligenz: Entity A kann (je nach Spezies und Entwicklung) die Memories aller Tiere derselben Art nutzen)
 *    - Führt die gewählte Aktion aus (1 Step á moveSpeed Länge).
 *
 *    Bei Bewegung:
 *        - Position wird aktualisiert.
 *        - Chunk-Zugehörigkeit wird aktualisiert.
 *
 *    Bei Interaktionen:
 *        - Prüft, ob Ziel erreichbar ist (Vector.normalize von current → target < moveSpeed).
 *        - Führt Aktionen aus:
 *            - Trinken
 *            - Essen
 *            - Kämpfen
 *            - Fortpflanzen
 *
 *
 * Grundprinzip:
 *
 * Wahrnehmen → Bewerten → Entscheiden → Ausführen
 */