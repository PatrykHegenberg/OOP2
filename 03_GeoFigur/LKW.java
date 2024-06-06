package fuhrpark.fahrzeuge;

public class LKW extends Fahrzeug{
	// Attribute
	double zulGGw;	//zulässiges Gesamtgewicht

	// Konstruktoren

	public LKW(String kennzeichen, String marke, int ps, int kmStand, String mietStatus, double zulGGw) {
		super(kennzeichen, marke, ps, kmStand, mietStatus);
		this.zulGGw = zulGGw;
		
	}

	// Methoden
	@Override
	public String infoKMStand() {
	
		String infoLKW = ", es ist ein LKW mit dem zul Gesamtgewicht von " + zulGGw + " t";
		return super.infoKMStand() + infoLKW;
	}
	
	
	

}
