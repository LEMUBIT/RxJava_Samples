/*
* periodically gather items emitted by an Observable into bundles and emit these bundles rather than emitting the items one at a time
*
* The Buffer operator transforms an Observable that emits items into an Observable that emits buffered collections of those items.
* There are a number of variants in the various language-specific implementations of Buffer that differ in how they choose which items
* go in which buffers.
  Note that if the source Observable issues an onError notification, Buffer will pass on this notification immediately without first
  emitting the buffer it is in the process of assembling, even if that buffer contains items that were emitted by the source Observable
  before it issued the error notification.
*
*
* */
package TransformingObservables;

import rx.Observable;
import rx.Scheduler;

public class Buffer {
    public static void main(String[] args) {
        Observable.just(2,3,5,6,6,7,3).buffer(2).subscribe(
                integerList -> System.out.println(integerList+":Size="+integerList.size()),
                throwable -> System.out.println("error"),
                ()->System.out.println("Completed")

        );
    }
}
