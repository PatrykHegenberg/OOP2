package OOP2;

import java.awt.Graphics;
/**
 * Die Klasse {@code RectangleShape} implementiert das {@link Shape}-Interface
 * und stellt Methoden zum Zeichnen von Rechtecken bereit.
 */
public class RectangleShape implements Shape {
      /**
     * Zeichnet ein Rechteck mit den angegebenen Parametern.
     *
     * @param g      Das {@link Graphics}-Objekt zum Zeichnen.
     * @param x      Die x-Koordinate des Ursprungspunkts des Rechtecks.
     * @param y      Die y-Koordinate des Ursprungspunkts des Rechtecks.
     * @param width  Die Breite des Rechtecks.
     * @param height Die Höhe des Rechtecks.
     */
    @Override
    public void draw(Graphics g, int x, int y, int width, int height) {
        g.drawRect(x, y, width, height);
    }
}
