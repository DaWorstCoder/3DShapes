import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class GamePanel extends JPanel implements ActionListener {
    static int width = 500;
    static int height = 500;

    static Timer timer;
    static int delay = 10;

    Cube outsideCube = new Cube(100, Color.blue);
    Diamond diam = new Diamond(75, .75, .5, 1, Color.cyan);

    GamePanel() {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.black);
        this.setFocusable(true);

        timer = new Timer(delay, this);
        timer.start();

        // Sets diamond straight
        diam.rotate(90, false, 0, false, 0, false);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    void draw(Graphics g) {
        outsideCube.render(g);
        diam.render(g);
    }

    // Use this if you want something to happen repeatedly
    @Override
    public void actionPerformed(ActionEvent e) {
        outsideCube.rotate(1, true, 0, true, 1, false);
        diam.rotate(0, false, 1, true, 0, false);
        repaint();

    }
}