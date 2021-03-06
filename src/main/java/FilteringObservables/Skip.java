/*You can ignore the first n items emitted by an Observable and attend only to those items that come after,
by modifying the Observable with the Skip operator.*/
package FilteringObservables;

import rx.Observable;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Skip {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        Observable.interval(1, TimeUnit.SECONDS).take(5).skip(2).subscribe(
                integer -> System.out.println(integer),
                throwable -> System.out.println("Error!"),
                () -> {
                    latch.countDown();
                    System.out.println("Completed");
                }
        );

            latch.await();

        //skip for some time
        /*There is also a variant of skip that takes a temporal duration rather than a quantity of items.
        It drops those items that are emitted during that initial duration of the source Observable’s lifespan.
        You set this duration by passing in a length of time and the time units this length is denominated in as parameters to skip.*/
        CountDownLatch latch2 = new CountDownLatch(1);
        Observable.interval(1, TimeUnit.MILLISECONDS).skip(10,TimeUnit.SECONDS).subscribe(
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
