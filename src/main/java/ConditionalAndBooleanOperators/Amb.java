/*given two or more source Observables, emit all of the items from only the first of these Observables to emit an item or notification*/

/*When you pass a number of source Observables to Amb, it will pass through the emissions and notifications of exactly one of these
Observables: the first one that sends a notification to Amb, either by emitting an item or sending an onError or onCompleted notification.
Amb will ignore and discard the emissions and notifications of all of the other source Observables.*/
package ConditionalAndBooleanOperators;

import rx.Observable;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Amb {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        Observable first = Observable.just(5, 5, 5).delay(5, TimeUnit.SECONDS);
        Observable second = Observable.just(2, 2, 2).delay(2, TimeUnit.SECONDS);

        Observable.amb(first, second).subscribe(
                o -> System.out.println(o),
                throwable -> System.out.println("Error"),
                () -> {
                    System.out.println("Completed");
                    latch.countDown();
                }

        );

        latch.await();
    }
}
