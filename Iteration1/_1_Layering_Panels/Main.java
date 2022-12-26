package Iteration1._1_Layering_Panels;

import java.awt.*;
import javax.swing.*;

public class Main {
  public static void main(String[] args) {
    Dimension dim = new Dimension(640, 640);
    JFrame frame = new JFrame("_1_Layering_Panels");
    frame.setSize(dim);
    JLayeredPane layeredPane = new JLayeredPane();
    layeredPane.setSize(dim);
    layeredPane.setPreferredSize(dim);
    Point topLeft = new Point(0, 0);
    for (int n = 0; n < 24; n++) {
      Point pos = new Point(topLeft);
      if (n % 4 == 0) {
        dim.width /= 2;
        topLeft.x += dim.width;
      } else if (n % 4 == 1) {
        dim.height /= 2;
        pos.y += dim.height;
      } else if (n % 4 == 2) {
        dim.width /= 2;
        pos.x += dim.width;
      } else {
        dim.height /= 2;
        topLeft.y += dim.height;
      }
      float r = 0, g = 0, b = 0, a = 0;
      if (n % 5 == 0)
        r = 1.0f;
      if (n % 5 == 1)
        g = 1.0f;
      if (n % 5 == 2)
        b = 1.0f;
      if (n % 5 == 3)
        r = g = 1.0f;
      if (n % 5 == 5)
        g = b = 1.0f;
      a = (float) Math.pow(1.1, -n);
      Color color = new Color(r, g, b, a);
      JPanel panel = new ColouredPanel(color, dim, pos);
      layeredPane.add(panel, Integer.valueOf(n));
    }
    layeredPane.setBackground(Color.RED);
    layeredPane.setOpaque(true);
    frame.setContentPane(layeredPane);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}