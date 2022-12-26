package Iteration1._2_Draggable_Selectable;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SettingsPanel extends JPanel {
  private Anchor selected = null;

  public SettingsPanel(Dimension dim) {
    super();
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    setSize(dim);
    setPreferredSize(dim);
    displayNone();
  }

  public JLabel createLabel(String text) {
    Font font = new Font("Segoe UI", Font.PLAIN, 20);
    JLabel label = new JLabel(text);
    label.setFont(font);
    return label;
  }

  public void display(Anchor anchor) {
    removeAll();

    if (selected != null) {
      selected.deselect();
    }

    selected = anchor;

    JLabel label = createLabel("Current Point: " + anchor.toString());
    add(label);

    JButton changeLabel = new JButton("Change Label");
    changeLabel.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String answer = JOptionPane.showInputDialog(this, "What would you like the label to be?");
        anchor.setID(answer);
        display(anchor);
      }
    });

    JLabel size = createLabel("Size: " + anchor.getAnchorSize());
    add(size);

    JButton increaseSize = new JButton("+");
    increaseSize.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        anchor.setAnchorSize(anchor.getAnchorSize() + 1);
        display(anchor);
      }
    });
    add(increaseSize);

    JButton decreaseSize = new JButton("-");
    decreaseSize.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        anchor.setAnchorSize(anchor.getAnchorSize() - 1);
        display(anchor);
      }
    });
    add(decreaseSize);

    JLabel colour = createLabel("Colour: " + anchor.getColor().toString());
    add(colour);

    JLabel position = createLabel("Position: " + anchor.getCentre().toString());
    add(position);

    validate();
    repaint();
  }

  public void displayNone() {
    removeAll();

    JLabel label = createLabel("Current Point: None");
    add(label);

    validate();
    repaint();
  }
}
