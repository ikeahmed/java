class A2 {
  void hello() {
    System.out.println("Hello from A2");
  }
}

class B2 extends A2 {
  void hello() {
    System.out.println("Hello from B2");
  }
}

class C2 extends B2 {
  void hello() {
    System.out.println("Hello from C2");
  }
}

class MethodOverriding2 {
  public static void main(String args[]) {
    A2 obj = new C2();
    obj.hello();
  }
}