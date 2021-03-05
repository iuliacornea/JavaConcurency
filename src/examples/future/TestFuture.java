package examples.future;

import java.util.concurrent.*;

public class TestFuture {

  public static void testSchedule() {
//    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
    ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    Future<Boolean> cpdHomework = scheduledExecutorService.schedule(new Homework("CPD"), 2, TimeUnit.SECONDS);
    Future<Boolean> notCpoHomework = scheduledExecutorService.schedule(new Homework("not CPD"), 5, TimeUnit.SECONDS);


    scheduledExecutorService.shutdown();

    while (!cpdHomework.isDone()) {
      try {
        Thread.sleep(500);
        notCpoHomework.cancel(true);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.print(".");
    }

    if (cpdHomework.isDone() && !cpdHomework.isCancelled()) {
      try {
        System.out.println("CPD homework was done today. T/F => " + cpdHomework.get().booleanValue());
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      }
    }
  }

  public static void testFixedRate() {

    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);

    scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
                                                   @Override
                                                   public void run() {
                                                     try {
                                                       System.out.println(Thread.currentThread().getName() + ": " + "Start");
                                                       Thread.sleep(20000);
                                                       System.out.println("Brush Brush Brushing my teeth");
                                                     } catch (InterruptedException e) {
                                                       e.printStackTrace();
                                                     }
                                                   }
                                                 },
            1, 1, TimeUnit.SECONDS);
  }
}
