/*determine whether two Observables emit the same sequence of items*/

/*Pass SequenceEqual two Observables, and it will compare the items
emitted by each Observable, and the Observable it returns will emit
true only if both sequences are the same (the same items, in the same
order, with the same termination state).*/

package ConditionalAndBooleanOperators;

import rx.Observable;

public class SequenceEqual {
    public static void main(String[] args) {
        Observable first = Observable.just(1, 3, 2);
        Observable second = Observable.just(1, 2, 3);
        Observable third = Observable.just(1, 2, 3);

        Observable.sequenceEqual(first, second).subscribe(
                o -> System.out.println(o),
                throwable -> System.out.println("Error"),
                () -> System.out.println("Completed not equal")
        );

        Observable.sequenceEqual(second, third).subscribe(
                o -> System.out.println(o),
                throwable -> System.out.println("Error"),
                () -> System.out.println("Completed equal")
        );
    }
}
