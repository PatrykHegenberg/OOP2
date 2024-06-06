package OOP2;

import java.awt.Graphics;
/**
 * Die Klasse {@code TriangleShape} implementiert das {@link Shape}-Interface
 * und stellt Methoden zum Zeichnen von Dreiecken bereit.
 */
public class TriangleShape implements Shape {
      /**
     * Zeichnet ein Dreieck mit den angegebenen Parametern.
     *
     * @param g      Das {@link Graphics}-Objekt zum Zeichnen.
     * @param x      Die x-Koordinate des Ursprungspunkts des Dreiecks.
     * @param y      Die y-Koordinate des Ursprungspunkts des Dreiecks.
     * @param width  Die Breite des Dreiecks.
     * @param height Die Höhe des Dreiecks.
     */
    @Override
    public void draw(Graphics g, int x, int y, int width, int height) {
        int[] xPoints = {x, x + width, x + width / 2};
        int[] yPoints = {y + height, y + height, y};
        g.drawPolygon(xPoints, yPoints, 3);
    }
}
