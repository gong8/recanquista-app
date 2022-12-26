package Iteration1._2_Draggable_Selectable;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.function.*;

public class Anchor extends JComponent {
  private int size;
  private String id;
  private boolean selected = false;
  private Point position, bottomRight;
  private Function<Point, Color> colorFunction;

  // the position offset to the screen that the pressed position is at
  private int offsetX, offsetY;

  public Anchor(Point position, String id, Point bottomRight, int size,
      Function<Point, Color> colorFunction,
      SettingsPanel settingsPanel) {
    super();
    this.id = id;
    this.size = size;
    this.position = position;
    this.bottomRight = bottomRight;
    this.colorFunction = colorFunction;
    setBounds(position.x, position.y, size, size);
    addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent e) {
      } // useless

      @Override
      public void mouseReleased(MouseEvent e) {
      } // useless

      @Override
      public void mouseExited(MouseEvent e) {
        setComponentCursor(Cursor.DEFAULT_CURSOR);
      }

      @Override
      public void mouseEntered(MouseEvent e) {
        setComponentCursor(Cursor.MOVE_CURSOR);
      }

      @Override
      public void mousePressed(MouseEvent e) {
        offsetX = e.getXOnScreen() - getX();
        offsetY = e.getYOnScreen() - getY();
        selected = !selected;
        if (selected) {
          settingsPanel.display(getSelf());
        } else {
          settingsPanel.displayNone();
        }
        repaint();
      }
    });

    addMouseMotionListener(new MouseMotionListener() {
      public void mouseDragged(MouseEvent e) {
        int x = e.getXOnScreen() - offsetX;
        int y = e.getYOnScreen() - offsetY;
        setPosition(new Point(x, y));
        updatePosition();
        settingsPanel.display(getSelf());
        selected = true;
      }

      public void mouseMoved(MouseEvent e) {
      }
    });
  }

  private Anchor getSelf() {
    return this;
  }

  private void updatePosition() {
    setBounds(position.x, position.y, size, size);
  }

  private void setPosition(Point position) {
    position.x = Math.max(Math.min(bottomRight.x - size, position.x), 0);
    position.y = Math.max(Math.min(bottomRight.y - size, position.y), 0);
    this.position = position;
  }

  private void setComponentCursor(int type) {
    setCursor(new Cursor(type));
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2.setColor(Color.BLACK);
    g2.fillArc(0, 0, size, size, 0, 360);
    g2.setColor(selected ? Color.YELLOW : Color.WHITE);
    g2.fillArc(1, 1, size - 2, size - 2, 0, 360);
    g2.setColor(Color.BLACK);
    g2.fillArc(4, 4, size - 8, size - 8, 0, 360);
    g2.setColor(getColor());
    g2.fillArc(5, 5, size - 10, size - 10, 0, 360);
  }

  public int getAnchorSize() {
    return this.size;
  }

  public void setAnchorSize(int newSize) {
    this.size = newSize;
    updatePosition();
  }

  public Color getColor() {
    return colorFunction.apply(getCentre());
  }

  public Point getCentre() {
    Point centre = new Point(position);
    centre.x += size / 2;
    centre.y += size / 2;
    return centre;
  }

  public Point getPosition() {
    return position;
  }

  public String toString() {
    return "Point$" + this.id;
  }

  public void deselect() {
    this.selected = false;
    repaint();
  }

  public void setID(String id) {
    this.id = id;
  }
}
