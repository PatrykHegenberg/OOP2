package geofigur.classes;

/**
 * Das Interface Resizable fuegt einer Klasse
 * durch die Methode resize() die Faehigkeit hinzu
 * die Flaeche des Objekts um den Faktor factor zu erhoehen
 * 
 * @author frank.krickel@iu.org
 * @version 02
 *
 */
public interface Resizable {
	/**
	 * Interfacemethode fuer Resizable
	 * @param factor eine positive double Zahl
	 * 
	 */
	public void resize(double factor);
}



