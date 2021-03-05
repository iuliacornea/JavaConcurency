package examples.executor;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class TestExecutorService {

  public static void watchNetflix() {

    System.out.println("Starting netflix from thread: " + Thread.currentThread().getName());
    ExecutorService netflix = Executors.newSingleThreadExecutor();
    netflix.execute(new WatchGOT());
    netflix.execute(new WatchLOTR());
//    netflix.shutdownNow();
    System.out.println("Shutdown netflix from thread: " + Thread.currentThread().getName());

    netflix.shutdown();
//     try to watch LOTR again and see what happens
    System.out.println("Try to watch LOTR from thread: " + Thread.currentThread().getName());
    netflix.execute(new WatchLOTR());
  }

  public static void fixedThreadPoolSize() {
    System.out.println("We are in thread: " + Thread.currentThread().getName());
//    Thread watchGotThread = new Thread(new WatchGOT());
//    watchGotThread.start();

    // creăm executor1
    // el face un pool cu 2 threaduri
    ExecutorService executor1 = Executors.newFixedThreadPool(2); // <- pool-1: pool-1-thread-1, pool-1-thread-2

    EmailSender emailSenderAna = new EmailSender("ana");
    executor1.execute(emailSenderAna);
    EmailSender emailSenderMaria = new EmailSender("maria");
    executor1.execute(emailSenderMaria);



    for (String girl : List.of("ana", "maria", "ioana", "valentina")) {
      EmailSender emailSender = new EmailSender(girl);
      // executor1, pune în lista de chestii de rulat si emailSender
      executor1.execute(emailSender);
    }
//    executor1 alege un thread dinre pool-1-thread-1 sau pool-1-thread-2
//    și thread-ul ăla rulează metoda run din emailSender
//    Email sent to ioana

    System.out.println("Finished sending tasks. Shutting down executor");
    try {
      Thread.sleep(800);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
//    executor1.shutdownNow();
//    executor1.shutdown();

//    ExecutorService executor2 = Executors.newFixedThreadPool(2);
//
//    for (String boy : List.of("ion", "gheorghe", "sorin", "andrei"))
//      executor2.execute(new EmailSender(boy));
//
//    executor2.shutdown();


    executor1 = Executors.newFixedThreadPool(3);

    for (String boy : List.of("ion", "gheorghe", "sorin", "andrei"))
      executor1.execute(new EmailSender(boy));

    executor1.shutdown();
  }

  public static void dynamicThreadPoolSize() {
    List<String> recipients = List.of("ana", "maria", "ioana", "valentina", "ion", "gheorghe", "sorin", "andrei");

    ExecutorService executorService = Executors.newCachedThreadPool();

    for (int i = 0; i <= Integer.MAX_VALUE; i++)
      executorService.execute(new EmailSender(recipients.get(Math.abs(new Random().nextInt() % 3))));

    executorService.shutdown();
  }

  public static void delay() throws InterruptedException {
    Thread.sleep(500);
    System.out.print(".");
    Thread.sleep(500);
    System.out.print(".");
    Thread.sleep(500);
    System.out.println(".");
  }
}
