package examples.future;

import examples.executor.WatchGOT;

import javax.xml.transform.sax.SAXSource;
import java.util.concurrent.*;

public class TestFuture {

  public static void testSchedule() {
//    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
    ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    Future<Boolean> cpdHomework = scheduledExecutorService.schedule(new Homework("CPD"), 5, TimeUnit.SECONDS);
    Future<Boolean> notCpoHomework = scheduledExecutorService.schedule(new Homework("not CPD"), 0, TimeUnit.SECONDS);


    scheduledExecutorService.shutdown();

    try {
      Thread.sleep(800);
      notCpoHomework.cancel(true);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.print(".");

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
                                                     System.out.println(Thread.currentThread().getName() + ": " + "Start");
                                                     try {
                                                       Thread.sleep(2000);
                                                     } catch (InterruptedException e) {
                                                       e.printStackTrace();
                                                     }
                                                     System.out.println("Brush Brush Brushing my teeth");
                                                   }
                                                 },
            1, 1, TimeUnit.SECONDS);

//    scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
//                                                   @Override
//                                                   public void run() {
//                                                     System.out.println(Thread.currentThread().getName() + ": " + "Start");
//                                                     System.out.println("Brush Brush Brushing my teeth");
//                                                   }
//                                                 },
//            1, 4, TimeUnit.SECONDS);
//
//    scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
//                                                   @Override
//                                                   public void run() {
//                                                     System.out.println(Thread.currentThread().getName() + ": " + "Take bath");
//                                                   }
//                                                 },
//            0, 1, TimeUnit.SECONDS);
  }
}
