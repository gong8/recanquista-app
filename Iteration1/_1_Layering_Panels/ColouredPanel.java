package Iteration1._1_Layering_Panels;

import java.awt.*;
import javax.swing.*;

public class ColouredPanel extends JPanel {
  public ColouredPanel(Color background, Dimension dim, Point pos) {
    super();
    setBounds(pos.x, pos.y, dim.width, dim.height);
    setBackground(background);
    setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
  }
}
