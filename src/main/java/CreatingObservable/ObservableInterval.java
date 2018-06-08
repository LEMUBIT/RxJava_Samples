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

        //toBlocking() can be used in place of countdown latch
        Observable.interval(1, TimeUnit.SECONDS).take(5).toBlocking().subscribe(
                integer -> System.out.println(integer),
                throwable -> System.out.println("Error!"),
                () -> System.out.println("Completed")
        );

    }
}
