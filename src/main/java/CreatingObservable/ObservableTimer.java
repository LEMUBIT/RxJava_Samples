//create an Observable that emits a particular item after a given delay
/*
* timer returns an Observable that emits a single number zero after a delay period you specify.
  timer by default operates on the computation Scheduler,
  or you can override this by passing in a Scheduler as a final parameter.
*
*/

package CreatingObservable;

import rx.Observable;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ObservableTimer {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        Observable.timer(1, TimeUnit.SECONDS).subscribe(
                s -> System.out.println(s),
                throwable -> System.out.println("Error"),
                () -> {
                    System.out.println("Completed");
                    latch.countDown();
                }
        );
        latch.await();
    }
}
