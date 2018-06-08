/*emit the most recent items emitted by an Observable within periodic time intervals*/
/*The Sample operator periodically looks at an Observable and emits whichever item it has most recently emitted since the previous sampling.

In some implementations, there is also a ThrottleFirst operator that is similar,
but emits not the most-recently emitted item in the sample period, but the first item that was emitted during that period.*/
package FilteringObservables;

import rx.Observable;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Sample {
    public static void main(String[] args) {

        Observable.interval(1, TimeUnit.MILLISECONDS).sample(2,TimeUnit.SECONDS).toBlocking().subscribe(
                integer -> System.out.println(integer),
                throwable -> System.out.println("Error!"),
                () -> System.out.println("Completed")
        );
    }

}
