/**
 * Die Klasse {@code GfDisplay} stellt eine grafische Darstellung für verschiedene geometrische Formen bereit.
 * Sie erbt von {@link JPanel} und implementiert das {@link GfDisplayInterface} Interface.
 * Diese Klasse ermöglicht es, verschiedene Formen wie Rechtecke, Kreise, Dreiecke und Ellipsen zu zeichnen.
 *
 * Beispiel zur Verwendung:
 * <pre>
 *     // Erstellung eines JFrame-Fensters
 *     JFrame frame = new JFrame("GfDisplay Test");
 *     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 *     frame.setSize(400, 400);
 *
 *     // Erstellung einer Instanz von GfDisplay
 *     GfDisplay gfDisplay = new GfDisplay();
 *
 *     // Beispiel: Zeichnen eines Rechtecks mit GfDisplay
 *     gfDisplay.drawShape(new RectangleShape(), 50, 50, 100, 50);
 *
 *     // Fügen Sie GfDisplay zum JFrame-Fenster hinzu
 *     frame.add(gfDisplay);
 *
 *     // Das JFrame-Fenster sichtbar machen
 *     frame.setVisible(true);
 * </pre>
 *
 * @see JPanel
 * @see GfDisplayInterface
 * @see ShapeDrawer
 * @see RectangleShape
 * @see CircleShape
 * @see TriangleShape
 * @see EllipseShape
 */
package OOP2;

import java.awt.*;
import javax.swing.*;

public class GfDisplay extends JPanel implements GfDisplayInterface {
    private int x;
    private int y;
    private int width;
    private int height;
    private ShapeDrawer shapeDrawer;

    @Override
    public void drawShape(ShapeDrawer shapeDrawer, int x, int y, int width, int height) {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        setShapeDrawer(shapeDrawer);
        repaint();
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setShapeDrawer(ShapeDrawer shapeDrawer) {
        this.shapeDrawer = shapeDrawer;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (shapeDrawer != null) {
            shapeDrawer.draw(g, x, y, width, height);
        }
    }
}
