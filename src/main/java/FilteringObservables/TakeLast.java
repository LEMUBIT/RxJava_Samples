/*emit only the final n items emitted by an Observable*/
package FilteringObservables;

import rx.Observable;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TakeLast {
    public static void main(String[] args) throws InterruptedException {
        rx.Observable.just(2,4,8).takeLast(1).subscribe(
                s->System.out.println("No:"+s),
                throwable -> System.out.println("Error"),
                ()->System.out.println("Completed")

        );


        /*There is also a variant of takeLast that takes a temporal duration rather than a quantity of items.
        It emits only those items that are emitted during that final duration of the source Observable’s lifespan.
        You set this duration by passing in a length of time and the time units this length is denominated in as parameters to takeLast.
        Note that this will delay the emission of any item from the source Observable until the source Observable completes.*/
        CountDownLatch latch = new CountDownLatch(1);
        Observable.interval(1, TimeUnit.SECONDS).take(5).takeLast(2,TimeUnit.SECONDS).subscribe(
                integer -> System.out.println(integer),
                throwable -> System.out.println("Error!"),
                () -> {
                    latch.countDown();
                    System.out.println("Completed takeLast seconds");
                }
        );

        latch.await();
    }
}
