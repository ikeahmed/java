class A1 {
  void hello() {
    System.out.println("Hello from A1");
  }
}

class B1 extends A1 {
  void hello() {
    System.out.println("Hello from B1");
  }
}

class C1 extends B1 {
  void hello() {
    System.out.println("Hello from C1");
  }
}

class MethodOverriding1 {
  public static void main(String args[]) {
    C1 obj = new C1();
    obj.hello();
  }
}