import java.awt.*;

class Diamond {
    int size;
    // Used to move to the center
    static int centerX = GamePanel.width / 2;
    static int centerY = GamePanel.height / 2;

    Color color;
    /** Cube points in 3D space **/
    Point3D[] points3D = {
        // Outer Points
        new Point3D(0, 1, 0),
        new Point3D(-Math.sin(2 * Math.PI / 5), Math.cos(2 * Math.PI / 5), 0),
        new Point3D(-Math.sin(2 * 2 * Math.PI / 5), Math.cos(2 * 2 * Math.PI / 5), 0),
        new Point3D(-Math.sin(3 * 2 * Math.PI / 5), Math.cos(3 * 2 * Math.PI / 5), 0),
        new Point3D(-Math.sin(4 * 2 * Math.PI / 5), Math.cos(4 * 2 * Math.PI / 5), 0),
        // Inner Points
        new Point3D(0, 1, 1),
        new Point3D(-Math.sin(2 * Math.PI / 5), Math.cos(2 * Math.PI / 5), 1),
        new Point3D(-Math.sin(2 * 2 * Math.PI / 5), Math.cos(2 * 2 * Math.PI / 5), 1),
        new Point3D(-Math.sin(3 * 2 * Math.PI / 5), Math.cos(3 * 2 * Math.PI / 5), 1),
        new Point3D(-Math.sin(4 * 2 * Math.PI / 5), Math.cos(4 * 2 * Math.PI / 5), 1),

        new Point3D(0, 0, -2)
    };

    public Diamond(int size, double innerSize, double innerHeight, double pointHeight, Color color) {
        this.color = color;

        // Multipying by size
        for (Point3D point : points3D) {
            point.x *= size;
            point.y *= size;
            point.z *= size;
        }

        // InnerSize
        for (int i = 5; i < 11; i++) {
            points3D[i].x *= innerSize;
            points3D[i].y *= innerSize;
        }

        // InnerHeight
        for (int i = 5; i < 11; i++) {
            points3D[i].z *= innerHeight;
        }

        // Setting the point height
        points3D[10].z *= pointHeight;
    }

    /** Array of all the points in 2D to be displayed on the JFrame **/
    Point[] points2D() {
        Point[] pointList = new Point[11];
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

    /** Draws the Diamond lines **/
    void render(Graphics g) {
        g.setColor(color);

        // Lines attached to bottom
        for (int i = 0; i < 5; i++) {
            g.drawLine(points2D()[i].x + centerX, points2D()[i].y + centerY, points2D()[10].x + centerX,
                    points2D()[10].y + centerY);
            g.drawLine(points2D()[i].x + centerX, points2D()[i].y + centerY, points2D()[i + 5].x + centerX,
                    points2D()[i + 5].y + centerY);
        }
        // Outer ring
        for (int i = 0; i < 4; i++) {
            g.drawLine(points2D()[i].x + centerX, points2D()[i].y + centerY, points2D()[i + 1].x + centerX,
                    points2D()[i + 1].y + centerY);
        }
        g.drawLine(points2D()[4].x + centerX, points2D()[4].y + centerY, points2D()[0].x + centerX,
                points2D()[0].y + centerY);

        // Inner ring
        for (int i = 5; i < 9; i++) {
            g.drawLine(points2D()[i].x + centerX, points2D()[i].y + centerY, points2D()[i + 1].x + centerX,
                    points2D()[i + 1].y + centerY);
        }
        g.drawLine(points2D()[9].x + centerX, points2D()[9].y + centerY, points2D()[5].x + centerX,
                points2D()[5].y + centerY);

    }

}