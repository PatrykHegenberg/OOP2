package OOP2;
/**
 * Das Interface {@code GfDisplayInterface} definiert Methoden zum Zeichnen verschiedener geometrischer Formen
 * auf einer grafischen Oberfläche.
 */
public interface GfDisplayInterface {
      /**
     * Zeichnet eine geometrische Form mit den angegebenen Parametern.
     *
     * @param shapeDrawer Das Objekt, das das {@link ShapeDrawer}-Interface implementiert und für das Zeichnen der Form verwendet wird.
     * @param x           Die x-Koordinate des Ursprungspunkts der Form.
     * @param y           Die y-Koordinate des Ursprungspunkts der Form.
     * @param width       Die Breite der Form.
     * @param height      Die Höhe der Form.
     */
    void drawShape(ShapeDrawer shapeDrawer, int x, int y, int width, int height);
}
