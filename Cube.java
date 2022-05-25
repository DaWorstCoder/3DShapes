import java.awt.*;
class Cube {
  int size;
  static int w2 = GamePanel.width/2;
  static int h2 = GamePanel.height/2;
  Color color;
  Point3D[] points3D;

  public Cube(Point3D[] points3D, int size, Color color) {
    this.points3D = points3D;
    this.color = color;

    for (Point3D point: points3D) {
      point.x *= size;
      point.y *= size; 
      point.z *= size;
    }
  }

  Point[] points2D() {
    Point[] pointList = new Point[8];
    int index = 0;
    for(Point3D points: points3D) {
      pointList[index] = points.convertTo2D();
      index++;
    }
    return pointList;
   }

  void rotate(int degreesX, boolean CWX, int degreesY, boolean CWY, int degreesZ, boolean CWZ) {
    for (Point3D points: points3D) {
      points.rotateX(CWX, degreesX);
      points.rotateY(CWY, degreesY);
      points.rotateZ(CWZ, degreesZ);
    }
  }

  
  void render(Graphics g) {
    g.setColor(color);
    //front
    for (int i = 0; i < 3; i++) {
      g.drawLine(points2D()[i].x + w2, points2D()[i].y + h2, points2D()[i + 1].x  + w2, points2D()[i + 1].y  + h2);
    } 
    g.drawLine(points2D()[3].x  + w2, points2D()[3].y + h2, points2D()[0].x + w2, points2D()[0].y + h2);

    //back
    for (int i = 4; i < 7; i++) {
      g.drawLine(points2D()[i].x + w2, points2D()[i].y + h2, points2D()[i + 1].x + w2, points2D()[i + 1].y + h2);
    } 
    g.drawLine(points2D()[7].x + w2, points2D()[7].y + h2, points2D()[4].x + w2, points2D()[4].y  + h2);

    //connections
    for (int i = 0; i < 4; i++) {
      g.drawLine(points2D()[i].x + w2, points2D()[i].y + h2, points2D()[i + 4].x + w2, points2D()[i + 4].y + h2);
    }
  }
  
}