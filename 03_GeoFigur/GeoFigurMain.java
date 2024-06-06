package geofigur;

import geofigur.classes.*;
import OOP2.GfDisplay;
import OOP2.ShapeDrawer;

/**
 * Kurs OOP2
 * Beispielprogramm GeoFigur
 * 
 * @author frank.krickel@iu.org
 * @version 02
 */
public class GeoFigurMain {
	/**
	 * Main-Klasse des Programms: Erzeugt Objekte, 
	 * enthaelt eine Liste von solchen Objekten
	 * 
	 * @param args nicht verwendet
	 */
	public static void main(String[] args) {
 // Erstellung eines neuen GfDisplay-Objekts
        GfDisplay gfDisplay = new GfDisplay();

        // Beispiel: Zeichnen eines Rechtecks mit GfDisplay
        gfDisplay.drawShape(new ShapeDrawer() {
            @Override
            public void draw(Graphics g, int x, int y, int width, int height) {
                g.drawRect(x, y, width, height);
            }
        }, 50, 50, 100, 50);
		// Drei Beispielobjekte werden erzeugt
		Rechteck rechteck1 = new Rechteck(5, 4);
		Rechteck rechteck2 = new Rechteck(6, 3);
		Kreis kreis1 = new Kreis(4);
		
		// Eine Liste, hier konkret: ein array, von GeoFiguren wird erzeugt
		GeoFigur[] figurenListe = new GeoFigur[10];

		// Die drei Beispielobjekte werden in die Collection kopiert
		// Hinweis: Dieser Schritt ist nur noch aus didaktischen Gründen enthalten,
		// natürlich könnte die Erzeugung auch direkt erfolgen, z.B.:
		// figurenListe[0] = new Rechteck(5, 4);
		figurenListe[0] = rechteck1;
		figurenListe[1] = rechteck2;
		figurenListe[2] = kreis1;

		// Ausgabe der ganzen Liste
		listeAusgeben(figurenListe);
		
		// Die Größe einzelner Elemente erhöhen
		figurenListe[1].resize(1.5);
		figurenListe[2].resize(1.5);
		
		listeAusgeben(figurenListe);

	}

	/*
	 * Ausgabe der Elemente der FigurenListe, die als Argument uebergeben wird
	 * @param fListe Array von GeoFigur - eine Liste aller Figuren
	 * 
	 */
	static private void listeAusgeben(GeoFigur[] fListe) {
		System.out.println("\nAnzahl der bislang erzeugten Objekte: " + GeoFigur.getAnzahl());
		for (GeoFigur f : fListe) {
			// Ausnutzen der Polymorphie: die abstrakten Methoden aus GeoFigur sind immer
			// aufrufbar
			// bei Rechteck und Kreis-Objekten
			if (f != null) {
				System.out.println(f);
				System.out.println("  Fläche: " + f.getFlaeche());
				System.out.println("  Umfang: " + f.getUmfang());
				System.out.println("  Volumen der Figur mit Höhe 5: " + f.getVolumeByHoehe(5));
				// Die folgende Anweisung führt zu einem Fehler, weil getKugelVolume nur für
				// Kreise
				// definiert ist --> deshalb auskommentiert
				// System.out.println(" Volumen einer Kugel mit gleicher Grundfläche: " +
				// f.getKugelVolume());
			}
		}
	}
}
