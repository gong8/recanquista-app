package Iteration1._2_Draggable_Selectable;

import java.awt.*;
import javax.swing.*;

public class Main {
  public static void main(String[] args) {
    // for (String fn :
    // GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames())
    // {
    // System.out.println(fn);
    // }

    Dimension dim = new Dimension(640, 640);
    JFrame frame = new JFrame("_2_Draggable_Selectable");

    SettingsPanel settingsPanel = new SettingsPanel(dim);

    JLayeredPane layeredPane = new JLayeredPane();
    layeredPane.setSize(dim);
    layeredPane.setPreferredSize(dim);
    layeredPane.setOpaque(true);

    BackgroundPanel background = new BackgroundPanel(dim.width, dim.height);
    layeredPane.add(background, Integer.valueOf(0));

    AnchorPanel anchorPanel = new AnchorPanel(dim.width, dim.height, background, settingsPanel);
    anchorPanel.addAnchor(new Point(10, 480), "richard");
    anchorPanel.addAnchor(new Point(50, 320), "of");
    anchorPanel.addAnchor(new Point(90, 240), "york");
    anchorPanel.addAnchor(new Point(200, 400), "gave");
    anchorPanel.addAnchor(new Point(420, 160), "battle");
    anchorPanel.addAnchor(new Point(460, 560), "in");
    anchorPanel.addAnchor(new Point(490, 80), "vain");
    layeredPane.add(anchorPanel, Integer.valueOf(1));

    JPanel contentPane = new JPanel();
    contentPane.setLayout(new FlowLayout());
    contentPane.add(layeredPane);
    contentPane.add(settingsPanel);

    frame.setContentPane(contentPane);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack(); // set size of frame to fit content pane
    frame.setVisible(true);
  }
}
