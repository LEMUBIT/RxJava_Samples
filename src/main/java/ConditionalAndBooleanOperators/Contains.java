/*determine whether an Observable emits a particular item or not*/

/*Pass the Contains operator a particular item, and the Observable it returns will
emit true if that item is emitted by the source Observable, or false if the source
Observable terminates without emitting that item.

A related operator, IsEmpty returns an Observable that emits true if and only if the
source Observable completes without emitting any items. It emits false if the source
Observable emits an item.*/

package ConditionalAndBooleanOperators;

import rx.Observable;

public class Contains {
    public static void main(String[] args) {
        Observable.just(1, 2, 3).contains(3).subscribe(
                aBoolean -> System.out.println(aBoolean),
                throwable -> System.out.println("Error"),
                () -> System.out.println("Completed")
        );
    }
}
