/*
The Interval operator returns an Observable that emits an infinite sequence
of ascending integers, with a constant interval of time of your choosing between emissions.
*/
package CreatingObservable;

import rx.Observable;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ObservableInterval {
    public static void main(String[] args) {
        //used to block until the observable is consumed:
        CountDownLatch latch = new CountDownLatch(1);
        Observable.interval(1, TimeUnit.SECONDS).take(5).subscribe(
                integer -> System.out.println(integer),
                throwable -> System.out.println("Error!"),
                () -> {
                    latch.countDown();
                    System.out.println("Completed");
                }
        );

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
