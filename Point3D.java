/** 3D Points **/
class Point3D {
    double x, y, z;

    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /** Converts 3D point to 2D **/
    Point convertTo2D() {
        double newX = y;
        double newY = z;
        double depth = 15 - x;
        double distance = Math.sqrt(Math.pow(newX, 2) + Math.pow(newY, 2));
        double theta = Math.atan2(newX, newY);
        double scale = Math.abs(1400 / (1400 + depth));
        distance *= scale;
        int X2D, Y2D;
        X2D = (int) (distance * Math.cos(theta));
        Y2D = (int) (distance * Math.sin(theta));
        Point point = new Point(X2D, Y2D);
        // System.out.println(point.x + ", " + point.y);
        return point;
    }

    void rotateX(boolean CW, double degrees) {
        double radius = Math.sqrt(Math.pow(y, 2) + Math.pow(z, 2));
        double theta = Math.atan2(z, y);
        theta += Math.toRadians(degrees * (CW ? -1 : 1));
        y = (radius * Math.cos(theta));
        z = (radius * Math.sin(theta));
    }

    void rotateY(boolean CW, double degrees) {
        double radius = Math.sqrt(Math.pow(x, 2) + Math.pow(z, 2));
        double theta = Math.atan2(z, x);
        theta += Math.toRadians(degrees * (CW ? -1 : 1));
        x = (radius * Math.cos(theta));
        z = (radius * Math.sin(theta));
    }

    void rotateZ(boolean CW, double degrees) {
        double radius = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        double theta = Math.atan2(y, x);
        theta += Math.toRadians(degrees * (CW ? -1 : 1));
        x = (radius * Math.cos(theta));
        y = (radius * Math.sin(theta));
    }
}