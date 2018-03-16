class Sphere {
  double x;
  double y;
  double z;
  double radius;

  Sphere() {
    this(0, 0, 0, 1);
  }

  Sphere(double radius) {
    this(0, 0, 0, radius);
  }

  Sphere(double x, double y, double z, double radius) {
    this.x = x;
    this.y = y;
    this.z = z;
    this.radius = radius;
  }

  void move(double x) {
    this.x = x;
  }

  void move(double x, double y) {
    this.x = x;
    this.y = y;
  }

  void move(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  void scale(double a) {
    radius *= a;
  }
}

class SphereOverloadMethod {

  public static void main(String args[]) {

    Sphere s = new Sphere(1.1, 3.4, -9.8, 10);
    s.move(-40, -40, -40);
    s.scale(0.1);
    System.out.println("s.x = " + s.x);
    System.out.println("s.y = " + s.y);
    System.out.println("s.z = " + s.z);
    System.out.println("s.radius = " + s.radius);
  }
}
  