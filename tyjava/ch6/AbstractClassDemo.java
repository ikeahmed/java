abstract class Shape {
  void display() {
  }
}

class Circle extends Shape {
  void display() {
    System.out.println("Circle");
  }
}

class Rectangle extends Shape {
  void display() {
    System.out.println("Rectangle");
  }
}

class Triangle extends Shape {
  void display() {
    System.out.println("Triangle");
  }
}

class AbstractClassDemo {
  public static void main(String args[]) {
    Shape s = new Circle();
    s.display();
    s = new Rectangle();
    s.display();
    s = new Triangle();
    s.display();
  }
}