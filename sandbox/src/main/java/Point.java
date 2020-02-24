public class Point {

    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double secondX(){
        return x;
    }

    public double secondY(){
        return y;
    }

    public double distance(Point secondpoint) {
        double x2 = x-secondpoint.secondX();
        double y2 = y-secondpoint.secondY();
        double d = Math.round(Math.sqrt(x2*x2+y2*y2));
        return d;

    }

}