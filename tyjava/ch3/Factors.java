class Factors {
  public static void main(String args[]) {
    int num = Integer.valueOf(args[0]).intValue();
    for(int i = 2; i < (num/2) + 1; i = i + 1) {
      if((num % i) == 0) System.out.print(i + " ");
    }
  }
}