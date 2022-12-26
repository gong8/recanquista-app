package Iteration2._1_Tabs;

import java.awt.*;
import javax.swing.*;

public class Main {
  public static void main(String[] args) {
    Dimension size = new Dimension(1280, 720);
    Dimension sidebarSize = new Dimension(128, 720);

    JFrame frame = new JFrame();
    frame.setSize(size);

    ContentPanel content = new ContentPanel(size);
    SideBar sidebar = new SideBar(sidebarSize);
    content.add(sidebar);

    frame.setContentPane(content);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
