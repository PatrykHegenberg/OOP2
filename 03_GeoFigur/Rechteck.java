package geofigur.classes;

/**
 * Die Klasse Rechteck ist eine Unterklasse von GeoFigur 
 * und implementiert das Interface Resizable
 * 
 * @author frank.krickel@iu.org
 * @version 02
 */
public class Rechteck extends GeoFigur implements Resizable {

	// Attribute
	private double laenge;
	private double breite;

	// Konstruktoren
	/**
	 * 
	 * @param l Laenge des Rechtecks
	 * @param b Breite des Rechtecks
	 */
	public Rechteck(double l, double b) {
		laenge = l;
		breite = b;
	}

	// Methoden

	/**
	 * Abstrakte Methode getFlaeche() überschreiben/implementieren
	 */
	public double getFlaeche() {
		return laenge * breite;
	}

	/**
	 *  Abstrakte Methode getUmfang() überschreiben/implementieren
	 */
	public double getUmfang() {
		return 2.0 * (laenge + breite);
	}

	/**
	 *  Abstrakte Methode getVolumeByHoehe() überschreiben/implementieren
	 */
	public double getVolumeByHoehe(double hoehe) {
		return laenge * breite * hoehe;
	}

	

	@Override
	public String toString() {
		return super.toString() + "Rechteck [laenge=" + laenge + ", breite=" + breite + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) breite;
		result = prime * result + (int) laenge;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rechteck other = (Rechteck) obj;
		if ((int) breite != (int) other.breite)
			return false;
		if ((int) laenge != (int) other.laenge)
			return false;
		return true;
	}

	/**
	 *  Methode resize() aus dem Interface Resizable implementieren
	 */
	public void resize(double factor) {
		if (factor < 0)
			System.out.println("Resize ist nicht möglich, weil factor <= 0!");
		else {
			laenge = Math.sqrt(factor) * laenge;
			breite = Math.sqrt(factor) * breite;
			System.out.println("Erfolgreicher Resize um Faktor " + factor);
		}
	}
}
