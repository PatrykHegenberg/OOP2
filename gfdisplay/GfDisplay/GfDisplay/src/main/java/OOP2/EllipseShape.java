package OOP2;

import java.awt.Graphics;
/**
 * Die Klasse {@code EllipseShape} implementiert das {@link Shape}-Interface
 * und stellt Methoden zum Zeichnen von Ellipsen bereit.
 */
public class EllipseShape implements Shape {
      /**
     * Zeichnet eine Ellipse mit den angegebenen Parametern.
     *
     * @param g      Das {@link Graphics}-Objekt zum Zeichnen.
     * @param x      Die x-Koordinate des Ursprungspunkts der Ellipse.
     * @param y      Die y-Koordinate des Ursprungspunkts der Ellipse.
     * @param width  Die Breite der Ellipse.
     * @param height Die Höhe der Ellipse.
     */
    @Override
    public void draw(Graphics g, int x, int y, int width, int height) {
        g.drawOval(x, y, width, height);
    }
}
