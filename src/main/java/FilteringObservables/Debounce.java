/*only emit an item from an Observable if a particular timespan has passed without it emitting another item*/
/*That means, supposed a value "A" is to be emitted, only emit it if a particular time has passed without another item e.g "B" is emitted
 *therefore the item "A" isn't really emitted immediately, until the timespan without another item being emitted is confirmed
  The Debounce operator filters out items emitted by the source Observable that are rapidly followed by another emitted item.
   */
package FilteringObservables;

import rx.Observable;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Debounce {
    public static void main(String[] args){
        //Tweaked version of ObservableInterval
        CountDownLatch latch = new CountDownLatch(1);
        Observable.interval(1, TimeUnit.SECONDS).take(5).debounce(1,TimeUnit.SECONDS).subscribe(
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

    /*Prints out '4' because it's the last item and only after that does the time interval remain after an item is emitted*/
}
