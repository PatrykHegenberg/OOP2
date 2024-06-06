package fuhrpark.fahrzeuge;

import java.util.Scanner;
import fuhrpark.Datum;

// Lösung zu Aufgabe 10-2-b: Klasse Fahrzeug wird abstrakt
public abstract class Fahrzeug {

	// Attribute
	private static int letzteFahrzeugID = 100;
	private int meineFahrzeugID;
	private String kennzeichen;
	private String marke;
	private int ps;
	private int kmStand;
	private String mietStatus;

	// Referenzattribut auf ein Datum
	private Datum inspektionsDatum = new Datum();

	// Konstruktoren
	public Fahrzeug() {
		getFahrzeugDatenPerDialog();
		meineFahrzeugID = letzteFahrzeugID++;
	}

	public Fahrzeug(String kennzeichen, String marke, int ps, int kmStand, String mietStatus) {
		this.kennzeichen = kennzeichen;
		this.marke = marke;
		this.ps = ps;
		this.kmStand = kmStand;
		this.mietStatus = mietStatus;
		setInspektionsDatum();
		meineFahrzeugID = ++letzteFahrzeugID;

	}

	// Getter

	public int getMeineFahrzeugID() {
		return meineFahrzeugID;
	}

	public String getKennzeichen() {
		return kennzeichen;
	}

	public String getMarke() {
		return marke;
	}

	public Datum getInspektionsDatum() {
		return inspektionsDatum;
	}

	public int getPs() {
		return ps;
	}

	public int getKmStand() {
		return kmStand;
	}

	public String getMietStatus() {
		return mietStatus;
	}

	public String infoKMStand() {
		return "Das Fahrzeug mit dem Kennzeichen " + kennzeichen + " hat den KM-Stand " + kmStand;
	}

	@Override
	public String toString() {
		String returnString;
		returnString = "\nFahrzeug-ID: " + getMeineFahrzeugID() +"\n";
		returnString += infoKMStand() +"\n";
		returnString += "Das Fahrzeug " + getKennzeichen() + " ist " + getMietStatus() + "\n";
		if (getInspektionsDatum() != null)
			returnString += "Nächste Inspektion am: " + getInspektionsDatum().datumZuString(false);
		else
			returnString += "Keine Inspektion geplant";	
		return returnString;
	}

	
	@Override
	public int hashCode() {
		return  meineFahrzeugID;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fahrzeug other = (Fahrzeug) obj;
		if (meineFahrzeugID != other.meineFahrzeugID)
			return false;
		return true;
	}

	// Methode zum setzen des Inspektionsdatums abhängig
	// vom km-Stand
	private void setInspektionsDatum() {
		int tempKM = 0; // temporäre Variable
		tempKM = (this.kmStand / 10000) * 10000; // rundet auf den letzten 10.000er-Stand ab

		if (this.kmStand < tempKM + 2000) // dann soll das Inspektionsdatum gesetzt werden
			inspektionsDatum.setDatum(2023, 7, 1);
		else // sonst auf null setzen
			inspektionsDatum = null;
	}

	private void getFahrzeugDatenPerDialog() {
		Scanner scan = new Scanner(System.in);
		System.out.println("\nNeues Fahrzeug anlegen -> Bitte die Fahrzeugdaten eingeben:");

		System.out.print("Kennzeichen: ");
		this.kennzeichen = scan.nextLine();

		System.out.print("Marke: ");
		this.marke = scan.nextLine();
		;

		System.out.print("PS: ");
		this.ps = scan.nextInt();
		scan.nextLine();

		System.out.print("KM-Stand: ");
		this.kmStand = scan.nextInt();
		scan.nextLine();

		System.out.print("Mietstatus: ");
		this.mietStatus = scan.nextLine();
		;

		setInspektionsDatum();

	}

}
