//periodically subdivide items from an Observable into Observable windows and emit these windows rather than emitting the items one at a time
/*
* Window is similar to Buffer, but rather than emitting packets of items from the source Observable, it emits Observables,
* each one of which emits a subset of items from the source Observable and then terminates with an onCompleted notification.

Like Buffer, Window has many varieties, each with its own way of subdividing the original Observable into the resulting Observable emissions,
each one of which contains a “window” onto the original emitted items. In the terminology of the Window operator, when a window “opens,”
this means that a new Observable is emitted and that Observable will begin emitting items emitted by the source Observable. When a window
“closes,” this means that the emitted Observable stops emitting items from the source Observable and terminates with an onCompleted
notification to its observers.
*
* */

package TransformingObservables;

import rx.Observable;

public class Window {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 3, 4, 9, 4)
                .window(2)
                .forEach(integerObservable -> integerObservable
                        .subscribe(integer -> System.out.println(integer),
                                throwable -> System.out.println("error"),
                                () -> System.out.println("Completed")
                        )

                );

    }
}
