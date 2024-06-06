package OOP2;

import OOP2.GfDisplay;
import OOP2.ShapeDrawer;
import OOP2.RectangleShape;
import OOP2.CircleShape;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
  public static void main(String[] args) {
    List<ShapeDrawer> shapes = new ArrayList<>();
    shapes.add(new RectangleShape(50, 50, 100, 50));
    shapes.add(new CircleShape(150, 50, 60, 50));

    GfDisplay display = new GfDisplay(shapes);
    display.initDisplay(shapes);
    // GfDisplay.initDisplay(shapes);

  }
}
