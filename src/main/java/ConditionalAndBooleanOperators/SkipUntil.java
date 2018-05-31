/*discard items emitted by an Observable until a second Observable emits an item*/

/*The SkipUntil subscribes to the source Observable, but ignores its emissions until
such time as a second Observable emits an item, at which point SkipUntil begins to mirror the source Observable.*/
package ConditionalAndBooleanOperators;

import rx.Observable;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class SkipUntil {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);

        Observable first = Observable.interval(4, TimeUnit.SECONDS).take(1);

        Observable second = Observable.interval(1, TimeUnit.SECONDS).take(7);

        second.skipUntil(first).subscribe(o -> System.out.println(o),
                throwable -> System.out.println("Error"),
                () -> {
                    System.out.println("Completed");
                    latch.countDown();
                }
        );

        latch.await();
    }
}
