/*discard any items emitted by an Observable after a second Observable emits an item or terminates*/

/*The TakeUntil subscribes and begins mirroring the source Observable. It also monitors a second
Observable that you provide. If this second Observable emits an item or sends a termination notification,
the Observable returned by TakeUntil stops mirroring the source Observable and terminates.*/


package ConditionalAndBooleanOperators;

import rx.Observable;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TakeUntil {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);

        Observable first = Observable.interval(4, TimeUnit.SECONDS).take(1);

        Observable second = Observable.interval(1, TimeUnit.SECONDS).take(7);

        second.takeUntil(first).subscribe(o -> System.out.println(o),
                throwable -> System.out.println("Error"),
                () -> {
                    System.out.println("Completed");
                    latch.countDown();
                }
        );

        latch.await();
    }
}
