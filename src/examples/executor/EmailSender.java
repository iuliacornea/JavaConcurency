package examples.executor;

import java.util.Random;

class EmailSender implements Runnable {

  String recipient;

  public EmailSender(String recipient) {
    this.recipient = recipient;
  }

  @Override
  public void run() {
    try {
      Thread.sleep(Math.abs(new Random().nextInt() % 1000));
      System.out.println("From thread: " + Thread.currentThread().getName());
      System.out.println("Email sent to " + recipient);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
