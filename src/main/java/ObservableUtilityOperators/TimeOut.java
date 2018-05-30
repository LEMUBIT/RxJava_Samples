/*mirror the source Observable, but issue an error notification if a particular period of time elapses without any emitted items*/

/*The first variant accepts parameters that define a duration of time (a quantity of time, and a TimeUnit that this quantity is
denominated in). Each time the source Observable emits an item, timeout starts a timer, and if that timer exceeds the duration
before the source Observable emits another item, timeout terminates its Observable with an error (TimeoutException).

By default this variant of timeout operates on the computation Scheduler, but you can choose a different Scheduler by passing
it in as an optional third parameter to timeout*/
package ObservableUtilityOperators;

import rx.Observable;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TimeOut {
    public static void main(String[] args) throws InterruptedException {

        Observable.interval(2, TimeUnit.MILLISECONDS).take(5).timeout(1, TimeUnit.MILLISECONDS).subscribe(
                integer -> System.out.println(integer),
                throwable -> System.out.println("Error time out without backup! " + throwable) ,
                () ->  System.out.println("Completed")
        );




            /*A second variant of timeout differs from the first in that instead of issuing an error notification in case of a
            timeout condition, it instead immediately switches to a backup Observable that you specify.

            By default this variant of timeout operates on the computation Scheduler, but you can choose a different Scheduler
            by passing it in as an optional third parameter to timeout.*/
        CountDownLatch latch2 = new CountDownLatch(1);
        Observable observable = Observable.just(9, 9, 9);
        Observable.interval(2, TimeUnit.MILLISECONDS).take(5).timeout(1, TimeUnit.MILLISECONDS, observable).subscribe(
                integer -> System.out.println(integer),
                throwable -> System.out.println("Error time out with backup! " + throwable),
                () -> {
                    latch2.countDown();
                    System.out.println("Completed time out with backup");
                }
        );

        latch2.await();

    }
}
