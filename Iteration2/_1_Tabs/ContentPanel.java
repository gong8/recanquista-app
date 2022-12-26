package Iteration2._1_Tabs;

import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;

public class ContentPanel extends JPanel {
  private BufferedImage image;
  private Dimension size;

  public ContentPanel(Dimension size) {
    super();
    setSize(size);
    this.size = size;
    try {
      InputStream is = getClass().getResourceAsStream("./background.png");
      this.image = ImageIO.read(is);
    } catch (IOException ex) {
      ex.printStackTrace();
      this.image = null;
    }
    setLayout(null);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    g2.drawImage(this.image, 0, 0, this.size.width, this.size.height, null);
  }
}
