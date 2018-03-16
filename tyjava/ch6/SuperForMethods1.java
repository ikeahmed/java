class I1 {
  void hello(String s) {
    System.out.println("I1: " + s);
  }
}

class J1 extends I1 {
  void hello(String s) {
    super.hello(s);
    System.out.println("J1: " + s);
  }
}

class K1 extends J1 {
  void hello(String s) {
    super.hello(s);
    System.out.println("K1: " + s);
  }
}

class SuperForMethods1 {

  public static void main(String args[]) {

    System.out.println("Instantiating I1");
    I1 obj = new I1();
    obj.hello("Good morning");

    System.out.println("Instantiating J1");
    obj = new J1();
    obj.hello("Good afternoon");

    System.out.println("Instantiating K1");
    obj = new K1();
    obj.hello("Good evening");
  }
}