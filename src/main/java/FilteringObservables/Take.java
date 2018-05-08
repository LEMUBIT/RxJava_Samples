/*emit only the first n items emitted by an Observable*/

package FilteringObservables;

import rx.Observable;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Take {
    public static void main(String[] args) throws InterruptedException {
        rx.Observable.just(2,4,8).take(1).subscribe(
                s->System.out.println("No:"+s),
                throwable -> System.out.println("Error"),
                ()->System.out.println("Completed")

        );


        /*There is also a variant of take that takes a temporal duration rather than a quantity of items.
        It results in an Observable that emits only those items that are emitted during that initial duration
        of the source Observable’s lifespan. You set this duration by passing in a length of time and the time
        units this length is denominated in as parameters to take.*/
        CountDownLatch latch = new CountDownLatch(1);
        Observable.interval(1, TimeUnit.SECONDS).take(2,TimeUnit.SECONDS).subscribe(
                integer -> System.out.println(integer),
                throwable -> System.out.println("Error!"),
                () -> {
                    latch.countDown();
                    System.out.println("Completed take seconds");
                }
        );

        latch.await();
    }
}
