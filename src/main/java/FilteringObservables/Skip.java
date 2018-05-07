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

            //todo check
        CountDownLatch latch2 = new CountDownLatch(1);
        Observable.interval(1, TimeUnit.SECONDS).take(2).skip(2,TimeUnit.SECONDS).subscribe(
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
