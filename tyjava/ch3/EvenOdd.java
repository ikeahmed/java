class EvenOdd {
  public static void main(String args[]) {
    int i = Integer.valueOf(args[0]).intValue();
    if((i % 2) == 0) System.out.print("Even");
    if((i % 2) == 1) System.out.print("Odd");
    if((i % 2) == -1) System.out.print("Odd");
  }
}