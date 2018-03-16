class ThrowsDemo {

  public static void main(String args[]) {
    a();
  }

  public static void a() {
    try {
      b();
    }
    catch(ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
  
  public static void b() throws ClassNotFoundException {
    c();
  }

  public static void c() throws ClassNotFoundException {
    Class cls = Class.forName("java.lang.Integer");
    System.out.println(cls.getName());
    System.out.println(cls.isInterface());
  }
}