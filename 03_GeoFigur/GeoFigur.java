package geofigur.classes;

/**
 * @author frank.krickel@iu.org
 * @version 02
 * 
 * Die abstrakte Klasse GeoFigur ist die Oberklasse fuer die
 *          konkreten Klassen Rechteck, Kreis, ...
 * 
 */
public abstract class GeoFigur implements Resizable {
	// Attribute

	private static int anzahl = 0;
	protected final double PI = 3.1415926;

	// Konstruktor
	/**
	 * bei Erzeugung eines Objekts wird die statische Variable anzahl hochgezaehlt
	 */
	public GeoFigur() {
		anzahl++;
	}

	// Methoden

	/**
	 * Klassenmethode zur Ermittlung der Anzahl von erzeugten Geofiguren
	 * 
	 * @return (int) Anzahl der erzeugten GeoFiguren
	 */
	public static int getAnzahl() {
		return anzahl;
	}

	/**
	 * (Abstrakte) Methode zur Rueckgabe der Flaeche
	 * 
	 * @return (double) Flaeche
	 */
	public abstract double getFlaeche();

	/**
	 * (Abstrakte) Methode zur Rueckgabe des Umfangs
	 * 
	 * @return (double) Umfang
	 */
	public abstract double getUmfang();

	/**
	 * Methode zur Ausgabe von Detailinformationen zum Objekt,
	 * sollte in der Unterklasse überschrieben werden
	 * 
	 */
	@Deprecated
	public void print() {
		System.out.print("GeoFigur-Informationen zu... ");
	}

	/**
	 * (Abstrakte) Methode zur Rueckgabe des Volumens 
	 * eines dreidimensionalen Objekts mit dem Objekt 
	 * als Grundflaeche und der als Parameter anzugebenden Hoehe
	 * 
	 * @param h Hoehe des Objekts
	 * @return (double) Volumen
	 */
	public abstract double getVolumeByHoehe(double h);

	@Override
	public String toString() {
		return "GeoFigur-Informationen zu... ";
	}

}
