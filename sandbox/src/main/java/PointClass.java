import org.testng.Assert;

public class PointClass {

    public static void main(String[] args) {
        Point p1 = new Point(0,0);
        Point p2 = new Point(3, 4);
        Point p3 = new Point(5, 10);

        Assert.assertEquals(p1.distance(p2),5.0);
        Assert.assertEquals(p1.distance(p3),11.0);
        Assert.assertEquals(p2.distance(p3),6.0);
    }

}