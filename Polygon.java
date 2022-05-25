import java.awt.*;

class Polygon {

  Point[] points;
  Point[] pointTest = {
    new Point(-1, -1),
    new Point(-1, 1),
    new Point(1, 1),
    new Point(1, -1)
  };
  
  public Polygon(Point[] points) {
    this.points = points;
  }

  void draw(Graphics g) {
    for (int i = 0; i < points.length - 1; i++) {
      g.drawLine(points[i].x, points[i].y, points[i + 1].x, points[i + 1].y);
    }
    g.drawLine(points[points.length - 1].x, points[points.length - 1].y, points[0].x, points[0].y);
    
  }

  
}