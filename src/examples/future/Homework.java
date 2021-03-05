package examples.future;

import java.util.Random;
import java.util.concurrent.Callable;

public class Homework implements Callable {

  private String subject;

  public Homework(String subject) {
    this.subject = subject;
  }

  @Override
  public Object call() throws Exception {
    System.out.println("Starting to do homework for " + subject);
    Thread.sleep(2000);
    Boolean success = new Random().nextBoolean();
    if (success) {
      System.out.println("Finished homework for " + subject);
    } else {
      System.out.println("Tomorrow, tomorrow... I love ya tomorrow");
    }
    return success;
  }

}
