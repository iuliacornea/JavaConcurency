package main;

import examples.executor.TestExecutorService;
import examples.future.TestFuture;
import examples.streams.TestStreams;

public class Application {

  public static void main(String[] args) {
//    TestExecutorService.watchNetflix();
//    TestFuture.testSchedule();
    TestFuture.testFixedRate();
//    TestStreams.trippledEvens();

//    TestExecutorService.fixedThreadPoolSize();
//    TestExecutorService.dynamicThreadPoolSize();
//    BadThreads.fixedThreadPoolSize();
//    BadThreads.dynamicThreadPoolSize();
//    TestStreams.sequentialVsParallel();
  }


}
