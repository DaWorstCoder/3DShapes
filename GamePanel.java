import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class GamePanel extends JPanel implements ActionListener{
  static int width = 500;
  static int height = 500;
  
  static Timer timer;
  static int delay = 10;
  int size = 1;
  Point3D[] cubeArray = {
    new Point3D(1, -1, -1),
    new Point3D(1, -1, 1),
    new Point3D(1, 1, 1),
    new Point3D(1, 1, -1),
    new Point3D(-1, -1, -1),
    new Point3D(-1, -1, 1),
    new Point3D(-1, 1, 1),
    new Point3D(-1, 1, -1)
  };
    Point3D[] cubeArrayTest = {
    new Point3D(1, -1, -1),
    new Point3D(1, -1, 1),
    new Point3D(1, 1, 1),
    new Point3D(1, 1, -1),
    new Point3D(-1, -1, -1),
    new Point3D(-1, -1, 1),
    new Point3D(-1, 1, 1),
    new Point3D(-1, 1, -1)
  };

  
  Cube outsideCube = new Cube(cubeArray, 100, Color.cyan);
  Cube insideCube = new Cube(cubeArrayTest, 50, Color.blue);
  
  GamePanel() {
    this.setPreferredSize(new Dimension(width, height));
    this.setBackground(Color.black);
    this.setFocusable(true);

    timer = new Timer(delay, this);
    timer.start();
    }

  public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

  void draw(Graphics g) {
    
      outsideCube.render(g);
      insideCube.render(g);

    // g.setColor(Color.white);
    // for (int i = 0; i < 8; i++) {
    //   g.drawLine(outsideCube.points2D()[i].x + w2, outsideCube.points2D()[i].y + h2, insideCube.points2D()[i].x + w2, insideCube.points2D()[i].y + h2);
    // }
    }


  @Override
    public void actionPerformed(ActionEvent e) {
        outsideCube.rotate(1, true, 1, true, 0, false);
        insideCube.rotate(1, false, 1, true, 0, true);
        repaint();
        

    }
}