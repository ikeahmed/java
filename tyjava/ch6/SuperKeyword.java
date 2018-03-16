class M100 {
  int i = 100;
}

class M200 extends M100 {
  int i = 200;
  void display() {
    System.out.println("i = " + i);
    System.out.println("super.i = " + super.i);
  }
}

class SuperKeyword {
  public static void main(String args[]) {
    M200 m200 = new M200();
    m200.display();
  }
}
    