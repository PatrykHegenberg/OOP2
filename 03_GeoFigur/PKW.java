package fuhrpark.fahrzeuge;

public class PKW extends Fahrzeug {
	// Attribute
	int anzahlSitzplaetze;

	// Konstruktoren
	public PKW(String kennzeichen, String marke, int ps, int kmStand, String mietStatus, int anzahlSitzplaetze) {
		super(kennzeichen, marke, ps, kmStand, mietStatus);
		this.anzahlSitzplaetze = anzahlSitzplaetze;
	}
	
	// Methoden
		@Override
		public String infoKMStand() {
			
			String infoPKW = ", es ist ein PKW mit " + anzahlSitzplaetze + " Sitzplätzen";
			return super.infoKMStand() + infoPKW;
		}
}
