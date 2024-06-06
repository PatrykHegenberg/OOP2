package fuhrpark;
import fuhrpark.fahrzeuge.*;

public class Fuhrparkverwaltung {

	public static void main(String[] args) {

		// ------------------------------------ Fahrzeuge laden -------------
		// Ein Array für alle Fahrzeuge
		Fahrzeug[] fahrzeugListe = new Fahrzeug[10]; 	// Vorsichtshalber auf 10 gesetzt
		// Fahrzeug 1 anlegen
		fahrzeugListe[0] = new PKW("H-XY 123", "VW", 140, 21100, "vermietet", 5);
		// Fahrzeug 2 anlegen
		fahrzeugListe[1] = new LKW("H-XY 654", "Audi", 220, 66222, "vermietet", 7.5);
		
		// Konsolenausgabe
		System.out.println("\nGeladene Fahrzeuge:");
		for (Fahrzeug f : fahrzeugListe) {
			if (f != null) {
				System.out.println( f);
				
			}			
		}

		// ----------------------------------------- Standorte laden -----------------
		// Standortliste
		Standort[] standortListe = new Standort[3];
		standortListe[0] = new Standort(1, "Zentrale", "34567", "Mittelhausen", "Hauptstraße 1", 6, 3);
		standortListe[1] = new Standort(2, "Nord", "12345", "Sielstadt", "Am Kanal 2", 4, 0);
		standortListe[2] = new Standort(3, "Süd", "89012", "Jodeldorf", "Bergweg 3", 2, 0);

		System.out.println("\nGeladene Standorte:");
		for (Standort s : standortListe)
			System.out.println(s);
	}

}
