package ConditionalAndBooleanOperators;

import rx.Observable;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TakeWhile {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);

        Observable.interval(1, TimeUnit.SECONDS).takeWhile(i -> i < 5).take(7).subscribe(
                aLong -> System.out.println(aLong),
                throwable -> System.out.println("Error"),
                () -> {
                    System.out.println("Completed");
                    latch.countDown();
                }
        );

        latch.await();
    }
}
