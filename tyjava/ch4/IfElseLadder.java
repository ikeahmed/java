class IfElseLadder {
  public static void main(String args[]) {
    int i = Integer.valueOf(args[0]).intValue();
    if(i < 0)
      System.out.print("Negative number");
    else if(i == 0)  
      System.out.print("Zero");
    else if(i == 1)
      System.out.print("One");
    else if(i == 2) 
      System.out.print("Two");
    else if(i == 3)
      System.out.print("Three");
    else
      System.out.print("Greater than three");
  }
}