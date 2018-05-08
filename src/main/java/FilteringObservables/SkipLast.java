/*suppress the final n items emitted by an Observable*/
/*You can ignore the final n items emitted by an Observable
and attend only to those items that come before them,
by modifying the Observable with the SkipLast operator*/
package FilteringObservables;

import rx.Observable;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class SkipLast {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        Observable.interval(1, TimeUnit.SECONDS).take(5).skipLast(2).subscribe(
                integer -> System.out.println(integer),
                throwable -> System.out.println("Error!"),
                () -> {
                    latch.countDown();
                    System.out.println("Completed");
                }
        );

        latch.await();

        //skip for some time
        /*There is also a variant of skipLast that takes a temporal duration rather than a quantity of items.
        It drops those items that are emitted during that final duration of the source Observable’s lifespan.
        You set this duration by passing in a length of time and the time units this length is denominated in as parameters to skipLast.*/
        CountDownLatch latch2 = new CountDownLatch(1);
        Observable.interval(1, TimeUnit.MILLISECONDS).skipLast(10,TimeUnit.SECONDS).subscribe(
                integer -> System.out.println(integer),
                throwable -> System.out.println("Error!"),
                () -> {
                    latch2.countDown();
                    System.out.println("Completed skip seconds");
                }
        );

        latch2.await();
    }
}
