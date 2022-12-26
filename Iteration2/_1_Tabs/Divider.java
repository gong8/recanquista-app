package Iteration2._1_Tabs;

import java.awt.*;
import javax.swing.*;

public class Divider extends JComponent {
  private Point position;
  private int width, thickness;

  public Divider(Point position, int width, int thickness) {
    super();
    setBounds(position.x, position.y, width, thickness);
    this.position = position;
    this.width = width;
    this.thickness = thickness;
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    Color color = new Color(0.8f, 0.8f, 1.0f, 0.8f);
    g2.setColor(color);
    g2.fillRect(0, 0, width, thickness);
  }
}
