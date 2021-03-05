package examples.streams;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStreams {

  public static void sequentialVsParallel() {
    String[] strings = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

    System.out.println("-------\nRunning sequential\n-------");
    executeStream(Arrays.stream(strings).sequential());
    System.out.println("-------\nRunning parallel\n-------");
    executeStream(Arrays.stream(strings).parallel());
  }

  public static void executeStream(Stream<String> stream) {

    stream.forEach(s -> {
      System.out.println(LocalTime.now() + " - value: " + s +
              " - thread: " + Thread.currentThread().getName());
      try {
        Thread.sleep(200);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
  }

  public static void trippledEvens() {
    Stream<Integer> ints = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    List<Integer> trippledEvens = ints
            .filter(even -> even % 2 == 0)
            .map(triple -> triple * 3)
            .collect(Collectors.toList());

    for(int nr : trippledEvens) {
      System.out.println(nr);
    }
  }
}
