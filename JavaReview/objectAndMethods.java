package Learning.JavaReview;

/*
Write a new method in Point called scale, that will make the point closer by half to (0,0). So for example, point (8, 4) after scale will be (4, 2).
*/

class Point{
    private double x;
    private double y;

    Point(){
        this.x = 0.0;
        this.y = 0.0;
    }

    Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    void scale(){
        this.x = this.x/2;
        this.y = this.y/2;
    }

    void printPoint() {
        System.out.println("(" + x + "," + y + ")");
    }

}

public class objectAndMethods  {
    public static void main(String[] args) {
        Point p0 = new Point(40, 85);
        p0.scale();
        p0.printPoint();
    }
}

/*
Learning Curve

class Point {
    int x;
    int y;

    Point() {
        this(0, 5);
    }

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    void printPoint() {
        System.out.println("(" + x + "," + y + ")");
    }
Point center(Point other) {
    // Returns the center between this point the other point
    // Notice we are using integer, we won't get an accurate value
    return new Point((x + other.x) / 2, (y + other.y) / 2);
}
}

public class objectAndMethods {
    public static void main(String[] args) {
        Point p0 = new Point();
        Point p1 = new Point(2, 4);
        p0.printPoint();
        p1.printPoint();
        Point p2 = p0.center(p1);
        p2.printPoint();
    }
}
*/