package Iteration1._2_Draggable_Selectable;

import java.awt.*;
import javax.swing.*;

import java.util.*;
import java.util.function.*;

public class AnchorPanel extends JPanel {
  private Function<Point, Color> func;
  private Point bottomRight;
  private SettingsPanel settingsPanel;
  private int width, height;
  private ArrayList<Anchor> anchors;

  public AnchorPanel(int width, int height, BackgroundPanel backgroundPanel, SettingsPanel settingsPanel) {
    super();
    this.width = width;
    this.height = height;
    setOpaque(false);
    setBounds(0, 0, width, height);
    setLayout(null);
    Function<Point, Color> func = new Function<Point, Color>() {
      public Color apply(Point t) {
        return backgroundPanel.colorAt((int) t.getX(), (int) t.getY());
      }
    };
    this.func = func;
    this.bottomRight = new Point(width, height);
    this.settingsPanel = settingsPanel;
    this.anchors = new ArrayList<Anchor>();
  }

  public void addAnchor(Point position, String id) {
    Anchor anchor = new Anchor(position, id, bottomRight, 32, func, settingsPanel);
    add(anchor);
    this.anchors.add(anchor);
  }
}
