package geofigur.classes;


/**
 * Die Klasse Kreis ist eine Unterklasse von GeoFigur 
 * und implementiert das Interface Resizable
 * 
 * @author frank.krickel@iu.org
 * @version 02
 */
public class Kreis extends GeoFigur implements Resizable {

	// Attribute
	private double radius;

	// Konstruktoren
	/**
	 * 
	 * @param r Radius des Kreises
	 */
	public Kreis(double r) {
		radius = r;
	}

	// Methoden

	/**
	 *  Abstrakte Methode getFlaeche() überschreiben/implementieren
	 */
	public double getFlaeche() {
		return PI * radius * radius;
	}

	/**
	 *  Abstrakte Methode getUmfang() überschreiben/implementieren
	 */
	public double getUmfang() {
		return 2 * PI * radius;
	}

	/**
	 *  Abstrakte Methode getVolumeByHoehe() überschreiben/implementieren
	 */
	public double getVolumeByHoehe(double hoehe) {
		return PI * radius * radius * hoehe;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Kreis [radius=" + radius + "]";
	}

	
	
	@Override
	public int hashCode() {
		return (int) radius ;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kreis other = (Kreis) obj;
		return (int) radius == (int) other.radius;
	}

	/**
	 *  Methode resize() aus dem Interface Resizable implementieren
	 */
	public void resize(double factor) {
		if (factor < 0)
			System.out.println("Resize ist nicht möglich, weil factor <= 0!");
		else {
			radius = Math.sqrt(factor) * radius;
			System.out.println("Erfolgreicher Resize um Faktor " + factor);
		}
	}

	/**
	 * Oeffentliche Methode, um das Volumen einer Kugel mit 
	 * demselben Radius zu ermitteln
	 * @return (double) Volumen dieser Kugel
	 */
	public double getKugelVolume() {
		return 4.0 / 3.0 * PI * radius * radius * radius;
	}
}
