class IntArray {
  public static void main(String args[]) {
    int array[] = new int[10];
    int i = -1;
    for(int index = 0; index < 10; index++) {
      array[index] = i--;
    }
    for(int index = 0; index < 10; index++) {
      System.out.println(array[index]);
    }
  }
}