package examples.executor;

import static examples.executor.TestExecutorService.delay;
public class WatchGOT implements Runnable {

  @Override
  public void run() {
    try {
      System.out.println(Thread.currentThread().getName() + ": " + "Start watching Game of Thrones");
      System.out.println(Thread.currentThread().getName() + ": " + "Wow, cool! Let's follow Daenerys's evolution!");
      delay();
      System.out.println(Thread.currentThread().getName() + ": " + "A few seasons later: Daenerys Stormborn of House Targaryen, the First of Her Name, Queen of the Andals and the First Men, Protector of the Seven Kingdoms, the Mother of Dragons, the Khaleesi of the Great Grass Sea, the Unburnt, the Breaker of Chains");
      delay();
      System.out.println(Thread.currentThread().getName() + ": " + "Are you for real???");
      System.out.println(Thread.currentThread().getName() + ": " + "THE END");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

}
