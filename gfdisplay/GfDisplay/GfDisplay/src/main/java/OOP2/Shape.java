package OOP2;

import java.awt.Graphics;
/**
 * Das Interface {@code Shape} definiert die Methode zum Zeichnen verschiedener geometrischer Formen.
 * Klassen, die dieses Interface implementieren, können verwendet werden, um spezifische Formen zu repräsentieren.
 */
public interface Shape {
      /**
     * Zeichnet die geometrische Form mit den angegebenen Parametern.
     *
     * @param g      Das {@link Graphics}-Objekt zum Zeichnen.
     * @param x      Die x-Koordinate des Ursprungspunkts der Form.
     * @param y      Die y-Koordinate des Ursprungspunkts der Form.
     * @param width  Die Breite der Form.
     * @param height Die Höhe der Form.
     */
    void draw(Graphics g, int x, int y, int width, int height);
}
