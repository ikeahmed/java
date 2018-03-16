class NormPriorityThread extends Thread {

  public void run() {
    for(int i = 0; i < 100000000; i++) {
    }
  }
}

class LowPriorityThread extends Thread {
 
  public void run() {
    setPriority(MIN_PRIORITY);
    try {
      for(int i = 0; i < Integer.MAX_VALUE; i++)
        System.out.println("Low priority thread: " + i);
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
}

class PriorityDemo {

  public static void main(String args[]) {

    // Create and start low priority thread
    LowPriorityThread lpt = new LowPriorityThread();
    lpt.start();

    // Wait for 2000 milliseconds
    try {
      Thread.sleep(2000);
    }
    catch(Exception e) {
      e.printStackTrace();
    }

    // Create and start normal priority thread
    NormPriorityThread npt = new NormPriorityThread();
    npt.start();
  }
}