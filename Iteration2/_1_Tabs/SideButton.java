package Iteration2._1_Tabs;

import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;

public class SideButton extends JComponent {
  private Point position;
  private Dimension size;
  private BufferedImage image;

  public SideButton(Point position, Dimension size, BufferedImage image) {
    super();
    setBounds(position.x, position.y, size.width, size.height);
    setOpaque(false);
    this.position = position;
    this.size = size;
    Image temp = image.getScaledInstance(size.width, size.height, Image.SCALE_SMOOTH);
    this.image = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2 = (Graphics2D) this.image.getGraphics();
    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
    g2.drawImage(temp, 0, 0, null);
    g2.dispose();
  }

  public SideButton(Dimension size, BufferedImage image) {
    this(new Point(0, 0), size, image);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
    g2.drawImage(this.image, 0, 0, null);
  }
}
