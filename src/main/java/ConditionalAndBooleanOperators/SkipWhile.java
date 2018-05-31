/*discard items emitted by an Observable until a specified condition becomes false*/

/*The SkipWhile subscribes to the source Observable, but ignores its emissions until
such time as some condition you specify becomes false, at which point SkipWhile begins
to mirror the source Observable.*/

package ConditionalAndBooleanOperators;

import rx.Observable;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class SkipWhile {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        Observable.interval(1, TimeUnit.SECONDS).skipWhile(i -> i < 5).take(7).subscribe(
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
