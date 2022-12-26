package Iteration2._1_Tabs;

import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import javax.imageio.*;

public class BackgroundPanel extends JPanel {
  private BufferedImage image;
  private Dimension size;

  public BackgroundPanel(Dimension size) {
    super();
    setSize(size);
    this.size = size;
    try {
      File file = new File("C:/Users/44774/Downloads/background.png");
      this.image = ImageIO.read(file);
    } catch (IOException ex) {
      ex.printStackTrace();
      this.image = null;
    }
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    g2.drawImage(this.image, 0, 0, this.size.width, this.size.height, null);
  }
}
