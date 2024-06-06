package OOP2;

import java.awt.Graphics;
/**
 * Die Klasse {@code CircleShape} implementiert das {@link Shape}-Interface
 * und stellt Methoden zum Zeichnen von Kreisen bereit.
 */
public class CircleShape implements Shape {
      /**
     * Zeichnet einen Kreis mit den angegebenen Parametern.
     *
     * @param g      Das {@link Graphics}-Objekt zum Zeichnen.
     * @param x      Die x-Koordinate des Ursprungspunkts des Kreises.
     * @param y      Die y-Koordinate des Ursprungspunkts des Kreises.
     * @param width  Die Breite des Kreises (Durchmesser).
     * @param height Die Höhe des Kreises (Durchmesser).
     */
    @Override
    public void draw(Graphics g, int x, int y, int width, int height) {
        g.drawOval(x, y, width, height);
    }
}
