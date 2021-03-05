package examples.executor;

import static examples.executor.TestExecutorService.delay;

public class WatchLOTR implements Runnable{

  @Override
  public void run() {
    try {
      System.out.println(Thread.currentThread().getName() + ": " + "Start watching Lord of the rings");
      System.out.println(Thread.currentThread().getName() + ": " + "The ring was made in the fires of Mount Doom. Only there can it be unmade");
      delay();
      System.out.println(Thread.currentThread().getName() + ": " + "Come, Mr. Frodo!' he cried. 'I can't carry it for you, but I can carry you.");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

}
