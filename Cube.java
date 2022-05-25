import java.awt.*;

class Cube {
    // Used to move to the center
    static int centerX = GamePanel.width / 2;
    static int centerY = GamePanel.height / 2;

    Color color;

    /** Points for the cube in 3D space **/
    Point3D[] points3D = {
        new Point3D(1, -1, -1),
        new Point3D(1, -1, 1),
        new Point3D(1, 1, 1),
        new Point3D(1, 1, -1),
        new Point3D(-1, -1, -1),
        new Point3D(-1, -1, 1),
        new Point3D(-1, 1, 1),
        new Point3D(-1, 1, -1)
    };

    public Cube(int size, Color color) {
        this.color = color;

        // Size multiplier
        for (Point3D point : points3D) {
            point.x *= size;
            point.y *= size;
            point.z *= size;
        }
    }

    /** Converts 3D points into 2D points **/
    Point[] points2D() {
        Point[] pointList = new Point[8];
        int index = 0;
        for (Point3D points : points3D) {
            pointList[index] = points.convertTo2D();
            index++;
        }
        return pointList;
    }

    void rotate(int degreesX, boolean CWX, int degreesY, boolean CWY, int degreesZ, boolean CWZ) {
        for (Point3D points : points3D) {
            points.rotateX(CWX, degreesX);
            points.rotateY(CWY, degreesY);
            points.rotateZ(CWZ, degreesZ);
        }
    }

    /** Draws the cube lines **/
    void render(Graphics g) {
        g.setColor(color);
        // front
        for (int i = 0; i < 3; i++) {
            g.drawLine(points2D()[i].x + centerX, points2D()[i].y + centerY, points2D()[i + 1].x + centerX,
                    points2D()[i + 1].y + centerY);
        }
        g.drawLine(points2D()[3].x + centerX, points2D()[3].y + centerY, points2D()[0].x + centerX,
                points2D()[0].y + centerY);

        // back
        for (int i = 4; i < 7; i++) {
            g.drawLine(points2D()[i].x + centerX, points2D()[i].y + centerY, points2D()[i + 1].x + centerX,
                    points2D()[i + 1].y + centerY);
        }
        g.drawLine(points2D()[7].x + centerX, points2D()[7].y + centerY, points2D()[4].x + centerX,
                points2D()[4].y + centerY);

        // connections
        for (int i = 0; i < 4; i++) {
            g.drawLine(points2D()[i].x + centerX, points2D()[i].y + centerY, points2D()[i + 4].x + centerX,
                    points2D()[i + 4].y + centerY);
        }
    }

}