class Circle {
  double x;
  double y;
  double radius;

  Circle(double radius) {
    this.radius = radius;
  }

  Circle(double x, double y, double radius) {
    this.x = x;
    this.y = y;
    this.radius = radius;
  }

  void move(double x, double y) {
    this.x = x;
    this.y = y;
  }

  void scale(double a) {
    radius *= a;
  }
}

class CircleMethods {

  public static void main(String args[]) {

    Circle c = new Circle(4);
    c.move(2, 2);
    c.scale(0.5);
    System.out.println("c.x = " + c.x);
    System.out.println("c.y = " + c.y);
    System.out.println("c.radius = " + c.radius);
  }
}
  