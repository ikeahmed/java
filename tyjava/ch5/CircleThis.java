class Circle {
  double x;
  double y;
  double radius;

  Circle(double x) {
    this(x, 0, 1);
  }

  Circle(double x, double y) {
    this(x, y, 1);
  }

  Circle(double x, double y, double radius) {
    this.x = x;
    this.y = y;
    this.radius = radius;
  }
}

class CircleThis {

  public static void main(String args[]) {

    Circle c = new Circle(1.1, 3.4, 10);
    System.out.println("c.x = " + c.x);
    System.out.println("c.y = " + c.y);
    System.out.println("c.radius = " + c.radius);
  }
}
  