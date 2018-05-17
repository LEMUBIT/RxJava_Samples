/*shift the emissions from an Observable forward in time by a particular amount*/
/*The Delay operator modifies its source Observable by pausing for a particular increment of
time (that you specify) before emitting each of the source Observable’s items.
This has the effect of shifting the entire sequence of items emitted by the Observable forward
in time by that specified increment.*/
package ObservableUtilityOperators;

import rx.Observable;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Delay {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        Observable.just(2, 3, 4).delay(5, TimeUnit.SECONDS).subscribe(
                integer -> System.out.println(integer),
                throwable -> System.out.println("Error"),
                () -> {
                    System.out.println("Completed");
                    latch.countDown();
                }
        );
        latch.await();
    }
}
