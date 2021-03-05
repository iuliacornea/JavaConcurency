package main;

import examples.executor.TestExecutorService;
import examples.future.TestFuture;
import examples.streams.TestStreams;

public class Application {

  public static void main(String[] args) {
//    TestExecutorService.watchNetflix();
//    TestExecutorService.fixedThreadPoolSize();
//    TestExecutorService.dynamicThreadPoolSize();

//    TestFuture.testSchedule();
//    TestFuture.testFixedRate();
    TestStreams.sequentialVsParallel();
  }


}
