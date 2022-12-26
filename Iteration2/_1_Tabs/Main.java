package Iteration2._1_Tabs;

import java.awt.*;
import javax.swing.*;

public class Main {
  public static void main(String[] args) {
    Dimension size = new Dimension(1280, 720);

    JFrame frame = new JFrame();
    frame.setSize(size);

    BackgroundPanel content = new BackgroundPanel(size);

    frame.setContentPane(content);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
