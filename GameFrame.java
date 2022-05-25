import javax.swing.*;
class GameFrame extends JFrame {
  GameFrame() {
    this.add(new GamePanel());
    this.setTitle("3D Shapes");
    this.pack();
    this.setVisible(true);
  }
}