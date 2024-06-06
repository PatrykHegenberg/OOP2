package fuhrpark;

public class Standort {
	// Atrribute
	private int standortNr;
	private String name;
	private String plz;
	private String ort;
	private String strasse;
	private int maximaleAnzahlFahrzeuge;
	private int aktuelleAnzahlFahrzeuge;

	// Konstruktoren
	public Standort(int standortNr, String name, String plz, String ort, String strasse, int maximaleAnzahlFahrzeuge,
			int aktuelleAnzahlFahrzeuge) {
		this.standortNr = standortNr;
		this.name = name;
		this.plz = plz;
		this.ort = ort;
		this.strasse = strasse;
		this.maximaleAnzahlFahrzeuge = maximaleAnzahlFahrzeuge;
		this.aktuelleAnzahlFahrzeuge = aktuelleAnzahlFahrzeuge;
	}

	// Getter
	public int getStandortNr() {
		return standortNr;
	}

	public String getName() {
		return name;
	}

	public String getPlz() {
		return plz;
	}

	public String getOrt() {
		return ort;
	}

	public String getStrasse() {
		return strasse;
	}

	public int getMaximaleAnzahlFahrzeuge() {
		return maximaleAnzahlFahrzeuge;
	}

	public int getAktuelleAnzahlFahrzeuge() {
		return aktuelleAnzahlFahrzeuge;
	}

	// Sonstige Methoden
	@Override
	public String toString() {
		return "Standort " + standortNr + ": " + name + "(" + plz + " " + ort + ")";
	}


	// Methoden für die Aufgabe C.1.3
	// Gibt zurück, ob ein Parkplatz frei ist
	public boolean istEinParkplatzfrei() {
		if (aktuelleAnzahlFahrzeuge < maximaleAnzahlFahrzeuge)
			return true;
		else
			return false;
	}

	// Fügt ein Fahrzeug hinzu
	public void fuegeFahrzeugHinzu() {
		aktuelleAnzahlFahrzeuge++;
	}

	// nimmt ein Fahrzeug weg
	public void nimmFahrzeugWeg() {
		aktuelleAnzahlFahrzeuge--;
	}

}
