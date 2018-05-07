/*do not emit any items from an Observable but mirror its termination notification*/
/*The IgnoreElements operator suppresses all of the items emitted by the source Observable,
but allows its termination notification (either onError or onCompleted) to pass through unchanged.

If you do not care about the items being emitted by an Observable, but you do want to be notified
when it completes or when it terminates with an error, you can apply the ignoreElements operator to
the Observable, which will ensure that it will never call its observers’ onNext handlers*/
package FilteringObservables;

import rx.Observable;

public class IgnoreElements {
    public static void main(String[] args) {
        Observable.just(8,4,5,6).ignoreElements().subscribe(
                integer -> System.out.println(integer),
                throwable -> System.out.println("It had an Error"),
                () -> System.out.println("It's Completed")
        );
    }
}
