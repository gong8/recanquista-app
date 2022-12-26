package Iteration2._1_Tabs;

import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;

public class SideBar extends JPanel {
  private Dimension size;

  public SideBar(Dimension size) {
    super();
    setBounds(0, 0, size.width, size.height);
    setOpaque(false);
    setLayout(null);
    this.size = size;

    Dimension boxSize = new Dimension(size.width, size.width);

    try {
      InputStream is = getClass().getResourceAsStream("./logo.png");
      BufferedImage logo = ImageIO.read(is);
      this.add(new SideButton(boxSize, logo));
      this.add(new Divider(new Point(4, boxSize.height + 4), boxSize.width - 8, 1));
      this.add(new SideButton(new Point(0, boxSize.height + 9), boxSize, logo));
      this.add(new Divider(new Point(4, boxSize.height * 2 + 13), boxSize.width - 8, 1));
      this.add(new SideButton(new Point(0, boxSize.height * 2 + 18), boxSize, logo));
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    Color layer = new Color(0.6f, 0.8f, 0.9f, 0.2f);
    g2.setColor(layer);
    g2.fillRect(0, 0, size.width, size.height);
  }
}
