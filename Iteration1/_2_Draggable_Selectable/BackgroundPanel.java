package Iteration1._2_Draggable_Selectable;

import java.awt.*;
import javax.swing.*;
import java.awt.image.*;

public class BackgroundPanel extends JPanel {
  private int width, height;

  public BackgroundPanel(int width, int height) {
    super();
    this.width = width;
    this.height = height;
    setBounds(0, 0, width, height);
  }

  private Color interpolate(int i) {
    float progress = (float) i / (float) width;
    int rgb = Color.HSBtoRGB(progress, 1, 1);
    return new Color(rgb);
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    // just adds antialiasing lmao
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
    for (int i = 0; i < width; i++) {
      g2.setColor(interpolate(i));
      g2.fillRect(i, 0, 2, height);
    }
  }

  public Color colorAt(int x, int y) {
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    Graphics2D g2 = (Graphics2D) image.getGraphics();
    printAll(g2);
    int rgb = image.getRGB(x, y);
    return new Color(rgb);
  }
}