/*emit only the last item (or the last item that meets some condition) emitted by an Observable*/
/*If you are only interested in the last item emitted by an Observable, or the last item that meets some criteria,
you can filter the Observable with the Last operator.

In some implementations, Last is not implemented as a filtering operator that returns an Observable,
but as a blocking function that returns a particular item when the source Observable terminates.
In those implementations, if you instead want a filtering operator, you may have better luck with TakeLast(1).*/

/*The BlockingObservable methods do not transform an Observable into another, filtered Observable,
but rather they break out of the Observable cascade, blocking until the Observable emits the desired
item, and then return that item itself.*/
package FilteringObservables;

import rx.Observable;

public class Last {
    public static void main(String[] args) {
        Observable.just(8,4,5,6,3).last(integer -> integer%2==0).subscribe(
                integer -> System.out.println(integer),
                throwable -> System.out.println("Error"),
                () -> System.out.println("Completed divisible by 2")
        );

        Observable.just(8,4,5,6,3).last().subscribe(
                integer -> System.out.println(integer),
                throwable -> System.out.println("Error"),
                () -> System.out.println("Completed last")
        );
    }
}
