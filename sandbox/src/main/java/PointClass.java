public class PointClass {

    public static double x1, y1, x2, y2;
    public static double x;
    public static double y;

    public static void main (String[] args) {
        PointClass p1 = new PointClass();
        PointClass p2 = new PointClass();

        p1.x1 = -4;
        p1.y1 = 10;
        p2.x2 = 0;
        p2.y2 = 13;


        System.out.println("Расстояние между точками " + p1.toString1(x1,y1) + " и " + p2.toString1(x2,y2) + " = " + distance(p1,p2));

    }

    public static double distance(PointClass p1, PointClass p2){

        return Math.sqrt((p2.x2 - p1.x1) * (p2.x2 - p1.x1) + (p2.y2 - p1.y1)*(p2.y2 - p1.y1));

    }

    public String toString1(double x, double y) {
        this.x = x;
        this.y = y;
        return "("+ x + ";" + y + ")";
    }
}
