/*emit a specified sequence of items before beginning to emit the items from the source Observable*/
/*If you want an Observable to emit a specific sequence of items before it begins emitting the items normally expected from it,
apply the StartWith operator to it.
(If, on the other hand, you want to append a sequence of items to the end of those normally emitted by an Observable,
you want the Concat operator.)*/
package CombiningObservables;

import rx.Observable;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class StartWith {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        Observable.interval(1, TimeUnit.SECONDS).take(5).skip(2).startWith(new Long(99), new Long(99)).subscribe(
                integer -> System.out.println(integer),
                throwable -> System.out.println("Error!"),
                () -> {
                    latch.countDown();
                    System.out.println("Completed");
                }
        );

        latch.await();

        System.out.println("---");

        /*You can also pass startWith an Observable, and it will prepend the emissions from that Observable
        to those of the source Observable to make its own set of emissions. This is a sort of inverted Concat operation.*/
        Observable observable = Observable.just(1, 2, 3);
        Observable.just(5, 6, 7).startWith(observable).subscribe(
                integer -> System.out.println(integer),
                throwable -> System.out.println(throwable),
                () -> System.out.println("Completed start with Observable")
        );
    }


}
