public class MyFirstProgram {

    public static void main(String[] args){
        Square s = new Square(5);
        Rectangle r = new Rectangle(4,6);
        hello("me");
        hello("you");

        System.out.println("Площадь квадрата со сторон l = " + s.l + " равна " + area(s));
        System.out.println("Площадь прямоугольника со сторонами a = " + r.a + " и b = " + r.b + " равна " + area(r));
    }

    public static void hello(String somebody){
        System.out.println("Hello " + somebody + "!");
    }

    public static double area(Square s){
        return s.l*s.l;
    }

    public static double area(Rectangle r){
        return r.a*r.b;
    }

}
